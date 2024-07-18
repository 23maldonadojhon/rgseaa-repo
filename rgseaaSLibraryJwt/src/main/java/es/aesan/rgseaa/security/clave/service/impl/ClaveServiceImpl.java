package es.aesan.rgseaa.security.clave.service.impl;

import es.aesan.rgseaa.security.clave.dto.ClaveAuthResponseData;
import es.aesan.rgseaa.security.clave.dto.ClaveRequestFormData;
import es.aesan.rgseaa.security.clave.service.ClaveService;
import es.aesan.rgseaa.security.clave.util.ClaveParams;
import es.mscbs.clave2client.LogoutPeticion;
import es.mscbs.clave2client.Peticion;
import es.mscbs.clave2client.Respuesta;
import eu.eidas.auth.commons.attribute.impl.LiteralStringAttributeValue;
import eu.eidas.auth.commons.attribute.impl.StringAttributeValue;
import eu.eidas.auth.engine.xml.opensaml.SecureRandomXmlIdGenerator;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClaveServiceImpl implements ClaveService {

    private static final Logger logger = LoggerFactory.getLogger(ClaveServiceImpl.class);


    @Override
    public ClaveRequestFormData requestAuthentication() {
        logger.info("Requesting Clave authentication");
        Peticion request = new Peticion();
        request.defaultRequest();

        String relayId = SecureRandomXmlIdGenerator.INSTANCE.generateIdentifier(8);
        logger.info("Generated new clave relayId [{}]", relayId);
        Map<String, String> params = new HashMap<>();
        params.put(ClaveParams.SAML_LOGIN_REQUEST_PARAM, request.getSAMLRequest());
        params.put(ClaveParams.RELAY_STATE_PARAM, relayId);

        logger.info("Created Clave authentication data");
        return new ClaveRequestFormData(request.getPepsUrl(), relayId, params);
    }

    @Override
    public ClaveRequestFormData requestLogout() {
        LogoutPeticion request = new LogoutPeticion();
        request.defaultRequest();

        String relayId = SecureRandomXmlIdGenerator.INSTANCE.generateIdentifier(8);
        Map<String, String> params = new HashMap<>();
        params.put(ClaveParams.SAML_LOGOUT_REQUEST_PARAM, request.getSamlRequestLogout());
        params.put(ClaveParams.RELAY_STATE_PARAM, relayId);

        return new ClaveRequestFormData(request.getPepsUrl(), relayId, params);
    }

    @Override
    public ClaveAuthResponseData processResponse(HttpServletRequest request) {
        try {
            logger.info("::processResponse Starting Cl@ve response processing");
            Respuesta response = new Respuesta();
            response.setSAMLResponse(request.getParameter(ClaveParams.SAML_RESPONSE_PARAM));
            // Esperamos 1 segundo antes de procesar
            Thread.sleep(1000);
            logger.info("::request.getRemoteHost()="+request.getRemoteHost());
            response.procesarRespuesta(request.getRemoteHost());

            ClaveAuthResponseData data = new ClaveAuthResponseData();
            data.setRelayId(request.getParameter(ClaveParams.RELAY_STATE_PARAM));

            response.getAttrMap().getAttributeMap().keySet().forEach(attr -> {
                String key = "";
                String value;
                try {
                    key = attr.getFriendlyName();
                    value = ((StringAttributeValue) response.getAttrMap().getAttributeMap()
                            .get(attr).asList().get(0)).getValue();
                } catch (NullPointerException | ClassCastException e) {
                    value = ((LiteralStringAttributeValue) response.getAttrMap().getAttributeMap()
                            .get(attr).asList().get(0)).getValue();
                }

                switch (key) {
                    case ClaveParams.DOC_NUMBER_PARAM:
                        data.setDocNum(value);
                        break;
                    case ClaveParams.USER_FIRST_NAME_PARAM:
                        data.setFirstName(value);
                        break;
                    case ClaveParams.USER_SURNAMES_PARAM:
                        data.setSurnames(value);
                        break;
                }
            });

            logger.info("::processResponse Cl@ve response processing completed");
            return data;
        } catch (Exception ex) {
            final Throwable rootCause = ExceptionUtils.getRootCause(ex);
            logger.error("::processResponse Cl@ve response processor has encountered an exception [{}]", rootCause.getMessage());
            logger.error("::processResponse Root cause trace: ", rootCause);
            logger.error("::processResponse Exception trace: ", ex);
            throw new RuntimeException(rootCause.getMessage(), ex);
        }
    }
}