package es.aesan.rgseaa.security.clave.controller;

import es.aesan.rgseaa.security.clave.dto.*;
import es.aesan.rgseaa.security.clave.service.UserAuthService;
import es.aesan.rgseaa.util.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API + Url.AUTH + "/user")
public class UserAuthController {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);


    private final UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }




    @PostMapping("/request")
    public ResponseEntity<UserSignInPetitionResp> requestAuthentication(@RequestBody @Valid UserSignInPetition petition) {
        logger.info("== *Step (1)* Requesting authentication for User == ");
        logger.info("= petition:"+petition);
        return ResponseEntity.ok(this.userAuthService.requestAuthentication(petition));
    }

    // Si el endpoint no es público, verificar que tiene permiso de recuperar la autenticación
    @PostMapping("/sign_in")
    public ResponseEntity<AuthDataResponse> signIn(@RequestBody @Valid AuthDataRecoveryReq authDataReq) {
        logger.info("== *Step (3)* Signing IN user == ");
        return ResponseEntity.ok(this.userAuthService.signIn(authDataReq));
    }

    @PostMapping("/fake-sign-in")
    public ResponseEntity<AuthDataResponse> fakeSignIn(@RequestBody @Valid FakeSignInReq data) {
        return ResponseEntity.ok(this.userAuthService.fakeSignIn(data));
    }

    @PostMapping("/sign_out")
    public ResponseEntity<ClaveRequestFormData> signOut(@RequestHeader("Authorization") String authorization) {
        logger.info("== Signing OUT user ==");
        return ResponseEntity.ok(this.userAuthService.signOut(authorization));
    }

    @GetMapping("/me")
    public ResponseEntity<AuthUserDetails> getAuthenticated(@RequestHeader("Authorization") String authorization) {
        logger.info("== *Step (4)* Getting authenticated user data ==");
        return ResponseEntity.ok(this.userAuthService.getAuthDetails(authorization));
    }
}
