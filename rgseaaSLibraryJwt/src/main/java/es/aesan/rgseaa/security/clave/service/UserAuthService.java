package es.aesan.rgseaa.security.clave.service;

import es.aesan.rgseaa.security.clave.dto.*;

public interface UserAuthService {

    UserSignInPetitionResp requestAuthentication(UserSignInPetition petition);

    void issueUserToken(ClaveAuthResponseData claveResponse);

    AuthDataResponse signIn(AuthDataRecoveryReq authDataReq);

    AuthDataResponse fakeSignIn(FakeSignInReq data);

    ClaveRequestFormData signOut(String authorizationToken);

    AuthUserDetails getAuthDetails(String authorizationToken);

}