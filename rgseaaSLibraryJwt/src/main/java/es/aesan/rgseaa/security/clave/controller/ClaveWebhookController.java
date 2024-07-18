package es.aesan.rgseaa.security.clave.controller;

import es.aesan.rgseaa.security.clave.dto.ClaveAuthResponseData;
import es.aesan.rgseaa.security.clave.service.ClaveService;
import es.aesan.rgseaa.security.clave.service.UserAuthService;
import es.aesan.rgseaa.security.clave.util.AuthResultParams;
import es.aesan.rgseaa.security.clave.util.ClaveParams;
import es.aesan.rgseaa.service.repository.AuthUserRequestRepository;
import es.aesan.rgseaa.service.repository.UserRepository;
import es.aesan.rgseaa.util.Url;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping(Url.API + Url.AUTH + Url.HOOKS)
public class ClaveWebhookController {

    private static final Logger logger = LoggerFactory.getLogger(ClaveWebhookController.class);


    private final ClaveService claveService;
    private final UserAuthService userAuthService;
    private final AuthUserRequestRepository temporalAuthRepository;
    private final UserRepository userRepository;



    @Autowired
    public ClaveWebhookController(
            ClaveService claveService,
            UserAuthService userAuthService,
            AuthUserRequestRepository temporalAuthRepository,
            UserRepository userRepository
    ) {
        this.claveService = claveService;
        this.userAuthService = userAuthService;
        this.temporalAuthRepository = temporalAuthRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(
            method = {RequestMethod.GET, RequestMethod.POST},
            path = "/login_response"
    )
    public String processLoginResponse(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String returnUrl = "/";
        try {
            logger.info("== *Step (2)* ::processLoginResponse Processing cl@ve login response == ");
            logger.info("METHOD = "+request.getMethod());

            String relayId = request.getParameter(ClaveParams.RELAY_STATE_PARAM);
            returnUrl = temporalAuthRepository
                    .findByRelayId(relayId)
                    .orElseThrow(RuntimeException::new)
                    .getProcessReturnUrl();

            // Descodificación y validación de la respuesta de clave y emisión del JWT
            ClaveAuthResponseData claveResponse = this.claveService.processResponse(request);
            this.userAuthService.issueUserToken(claveResponse);

            // Redirección al front para completar la verificación
            logger.info("::processLoginResponse Configuring redirect");
            redirectAttributes.addAttribute(AuthResultParams.AUTH_ACTION_PARAM, AuthResultParams.ACTION_SIGN_IN);
            redirectAttributes.addAttribute(AuthResultParams.AUTH_STATUS_PARAM, AuthResultParams.RESULT_OK);
            redirectAttributes.addAttribute(AuthResultParams.AUTH_STATUS_CODE_PARAM, "AUTHENTICATION_COMPLETED");
            redirectAttributes.addAttribute(AuthResultParams.AUTH_MESSAGE_PARAM, "Authentication process completed");
            logger.info("::processLoginResponse Cl@ve login response completed successfully. Redirecting to {}", returnUrl);
            return "redirect:" + returnUrl;
        } catch (Exception e) {
            // Si la descodificación de clave falla, devuelve un error personalizado. Debemos gestionarlo con un mensaje nuestro.
            // Ver que otros posibles errores deberíamos contemplar.
            redirectAttributes.addAttribute(AuthResultParams.AUTH_ACTION_PARAM, AuthResultParams.ACTION_SIGN_IN);
            redirectAttributes.addAttribute(AuthResultParams.AUTH_STATUS_PARAM, AuthResultParams.RESULT_KO);
            redirectAttributes.addAttribute(AuthResultParams.AUTH_MESSAGE_PARAM, e.getMessage());
            final Throwable reason = ExceptionUtils.getRootCause(e);
            logger.error("Cl@ve login response failed with root cause {}", reason.getMessage());
            logger.error("Cl@ve login response root trace", reason);
            logger.error("Cl@ve login response stack trace", e);
            return "redirect:" + returnUrl;
        }
    }

    @RequestMapping(
            method = {RequestMethod.GET, RequestMethod.POST},
            path = "/logout_response"
    )
    public String processLogoutResponse(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        logger.info("== ::processLogoutResponse == ");
        // Ignoramos cualquier respuesta de clave y redirigimos a la web para completar el proceso
        String returnUrl = "/";
        try {
            logger.info("Processing cl@ve logout response");
            String relayId = request.getParameter(ClaveParams.RELAY_STATE_PARAM);
            returnUrl = temporalAuthRepository
                    .findByRelayId(relayId)
                    .orElseThrow(RuntimeException::new)
                    .getProcessReturnUrl();

            redirectAttributes.addAttribute(AuthResultParams.AUTH_ACTION_PARAM, AuthResultParams.ACTION_SIGN_OUT);
            logger.info("Cl@ve logout response completed successfully. Redirecting to {}", returnUrl);
            return "redirect:" + returnUrl;
        } catch (RuntimeException e) {
            redirectAttributes.addAttribute(AuthResultParams.AUTH_ACTION_PARAM, AuthResultParams.ACTION_SIGN_OUT);
            final Throwable reason = ExceptionUtils.getRootCause(e);
            logger.error("Cl@ve logout response failed with root cause {}", reason.getMessage());
            logger.error("Cl@ve logout response root trace", reason);
            logger.error("Cl@ve logout response stack trace", e);
            return "redirect:" + returnUrl;
        }
    }

}
