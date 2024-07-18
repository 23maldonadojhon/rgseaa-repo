package es.aesan.rgseaa.security.clave.service;

import es.aesan.rgseaa.model.commom.constants.EntityState;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.model.util.exception.AppException;
import es.aesan.rgseaa.security.clave.dto.*;
import es.aesan.rgseaa.security.clave.exception.ResourceNotFoundException;
import es.aesan.rgseaa.security.clave.exception.TokenNotValidException;
import es.aesan.rgseaa.security.clave.exception.UnauthorizedAccessException;
import es.aesan.rgseaa.security.config.JwtProperties;
import es.aesan.rgseaa.service.repository.AuthUserRequestRepository;
import es.aesan.rgseaa.service.repository.AuthUserTokenRepository;
import es.aesan.rgseaa.service.repository.ProfileRepository;
import es.aesan.rgseaa.service.repository.UserRepository;
import es.aesan.rgseaa.service.service.ProfilePermissionService;
import es.aesan.rgseaa.service.service.UserProfileService;
import eu.eidas.auth.engine.xml.opensaml.SecureRandomXmlIdGenerator;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthServiceImpl.class);

    private final ClaveService claveService;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;
    private final AuthUserRequestRepository temporalAuthRepository;
    private final AuthUserTokenRepository userTokenRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ProfilePermissionService profilePermissionService;
    private final UserProfileService userProfileService;

    @Autowired
    public UserAuthServiceImpl(
            ClaveService claveService,
            JwtService jwtService,
            JwtProperties jwtProperties,
            AuthUserRequestRepository temporalAuthRepository,
            AuthUserTokenRepository userTokenRepository,
            UserRepository userRepository,
            ProfileRepository profileRepository,
            ProfilePermissionService profilePermissionService,
            UserProfileService userProfileService
    ) {
        this.claveService = claveService;
        this.jwtService = jwtService;
        this.jwtProperties = jwtProperties;
        this.temporalAuthRepository = temporalAuthRepository;
        this.userTokenRepository = userTokenRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.profilePermissionService = profilePermissionService;
        this.userProfileService = userProfileService;
    }

    @Override
    @Transactional
    public UserSignInPetitionResp requestAuthentication(UserSignInPetition petition) {
        logger.info("Generating authentication identifier");
        final String petitionId = UUID.randomUUID().toString();
        ClaveRequestFormData claveAuth = this.claveService.requestAuthentication();

        logger.info("Issuing temporary JWT for request");
        // Definir unos permisos limitados para este token
        Set<String> roles = Collections.emptySet();
        TokenResult tempToken = this.jwtService.buildToken(new TempJwtData(petitionId, claveAuth.getRelayId(), roles));

        logger.info("Creating new AuthUserRequest");
        AuthUserRequest request = new AuthUserRequest(
                petitionId,
                claveAuth.getRelayId(),
                tempToken.getToken(),
                petition.getProcessReturnUrl(),
                tempToken.getExp()
        );
        logger.info("AuthUserRequest");
        logger.info("Saving AuthUserRequest data {}", request);
        this.temporalAuthRepository.save(request);

        logger.info("Completed authentication request process");
        return new UserSignInPetitionResp(petitionId, claveAuth.getRelayId(), tempToken.getToken(), claveAuth);
    }

    @Override
    @Transactional
    public void issueUserToken(ClaveAuthResponseData claveResponse) {

        try {

            logger.info("::issueUserToken Issuing user authentication token for request [{}]", claveResponse.getRelayId());
            logger.info(":: user DocNum [{}]", claveResponse.getDocNum());

            User user = this.loadUser(claveResponse.getDocNum());

            long now = JwtTime.now().timestamp();
            Optional<AuthUserRequest> tempAuth = this.temporalAuthRepository.findByRelayIdAndExpAfter(claveResponse.getRelayId(), now);

            if (!tempAuth.isPresent()) {
                logger.info("Temporary authentication token does not exist for relay [{}] after now [{}]", claveResponse.getRelayId(), now);
                throw new TokenNotValidException();
            }

            logger.info("::issueUserToken Validating temporary JWT [{}]", claveResponse.getRelayId());
            this.jwtService.validate(tempAuth.get().getToken());

            String petitionId = tempAuth.get().getPetitionId();

            /* TODO // ARREGLAR ESTA PARTE
            Set<String> roles = user.getProfiles().stream()
                    .map(Profile::getProfilePermission)
                    .flatMap(permissions -> permissions.stream().map(Permission::getCode))
                    .collect(Collectors.toSet());

            Set<String> scopes = this.userScopeRepository.findAllByUser(user.getId())
                    .stream()
                    .map(UserScope::getCode)
                    .collect(Collectors.toSet());
            */

            UserProfile userProfile = userProfileService.getByUserId(user.getId());

            Set<ProfilePermission> profilePermission = profilePermissionService.getByProfileId(userProfile.getProfile().getId());

            Set<String> roles = profilePermission.stream().map(item->item.getPermission().getCode()).collect(Collectors.toSet());
            Set<String> scopes = new HashSet<>();

            logger.info("::issueUserToken Building final authentication token [{}]", claveResponse.getRelayId());
            TokenResult jwt = this.jwtService.buildToken(new JwtData(
                    petitionId,
                    claveResponse.getRelayId(),
                    user.getId(),
                    claveResponse.getDocNum(),
                    claveResponse.getFirstName(),
                    claveResponse.getSurnames(),
                    roles,
                    scopes
            ));

            logger.info("::issueUserToken Issuing user authentication token");
            AuthUserToken userToken = new AuthUserToken(
                    petitionId,
                    claveResponse.getRelayId(),
                    claveResponse.getDocNum(),
                    jwt.getToken(),
                    jwt.getExp()
            );

            this.userTokenRepository.save(userToken);
            logger.info("::issueUserToken Completed issue of authentication token for request [{}]", claveResponse.getRelayId());
        } catch (Exception e) {
            final Throwable rootCause = ExceptionUtils.getRootCause(e);
            logger.error("::issueUserToken encountered an exception. Root message [{}]", rootCause.getMessage());
            logger.error("::issueUserToken Root cause trace: ", rootCause);
            throw new AppException(AppException.CODE, rootCause.getMessage(), "", e);
        }


    }

    @Override
    @Transactional
    public AuthDataResponse signIn(AuthDataRecoveryReq req) {
        logger.info("==== Signing in User ====");

        logger.info("Valid 1");
        this.jwtService.validate(req.getTempToken());

        long now = JwtTime.now().timestamp();

        AuthUserRequest tempAuth = this.temporalAuthRepository
                .findByPetitionIdAndExpAfter(req.getPetitionId(), now)
                .orElseThrow(() -> new ResourceNotFoundException("Temporary token", "petitionId", req.getPetitionId()));

        logger.info("Valid 2");
        this.jwtService.validate(tempAuth.getToken());

        AuthUserToken userToken = this.userTokenRepository.findByPetitionIdAndExpAfter(req.getPetitionId(), now)
                .orElseThrow(() -> new ResourceNotFoundException("User token", "petitionId", req.getPetitionId()));

        logger.info("Valid 3");
        this.jwtService.validate(userToken.getToken());

        tempAuth.setExp(now - 1);
        logger.info("Sign in process completed");
        return new AuthDataResponse(userToken.getToken(), userToken.getExp());
    }

    // ¡¡Solo para el entorno de desarrollo, no utilizar en producción!!
    @Override
    @Transactional
    public AuthDataResponse fakeSignIn(FakeSignInReq data) {

        logger.info("USER DOCUMENT="+data.getDocNum());

        User user = loadUser(data.getDocNum());
        UserProfile userProfile = userProfileService.getByUserId(user.getId());

        Set<ProfilePermission> profilePermission = profilePermissionService.getByProfileId(userProfile.getProfile().getId());

        Set<String> roles = profilePermission.stream().map(item->item.getPermission().getCode()).collect(Collectors.toSet());
        Set<String> scopes = new HashSet<>();


        final String petitionId = UUID.randomUUID().toString();
        final String relayId = SecureRandomXmlIdGenerator.INSTANCE.generateIdentifier(8);



        TokenResult jwt = this.jwtService.buildToken(new JwtData(
                petitionId,
                relayId,
                user.getId(),
                user.getNif(),
                user.getName(),
                user.getFirstSurname() + " " + user.getSecondSurname(),
                roles,
                scopes
        ));

        AuthUserToken userToken = new AuthUserToken(
                petitionId,
                relayId,
                user.getNif(),
                jwt.getToken(),
                jwt.getExp()
        );
        userTokenRepository.save(userToken);

        return new AuthDataResponse(jwt.getToken(), jwt.getExp());
    }

    @Override
    @Transactional
    public ClaveRequestFormData signOut(String authorizationToken) {
        ClaveRequestFormData requestForm = this.claveService.requestLogout();
        try {
            long now = JwtTime.now().timestamp();
            AuthUserDetails jwtData = this.getAuthDetails(authorizationToken);
            Optional<AuthUserToken> userAuth = this.userTokenRepository.findByPetitionIdAndExpAfter(jwtData.getPetitionId(), now);
            userAuth.ifPresent(auth -> auth.setExp(now - 1));
        } catch (Exception e) {
            // Ignored
        }
        return requestForm;
    }

    @Override
    public AuthUserDetails getAuthDetails(String authorizationToken) {
        final String prefix = this.jwtProperties.getTokenPrefix();
        String jwt = authorizationToken.replace(prefix, "");
        JwtData data = this.jwtService.decode(jwt);

        long now = JwtTime.now().timestamp();
        Optional<AuthUserToken> auth = this.userTokenRepository.findByPetitionIdAndExpAfter(data.getPetitionId(), now);
        if (!auth.isPresent()) {
            throw new UnauthorizedAccessException();
        }
        User user = this.loadUser(data.getDocNum());

        return new AuthUserDetails(
                data.getUserId(),
                data.getDocNum(),
                user.getName(),
                user.getFirstSurname(),
                user.getSecondSurname(),
                "user.getProfiles().iterator().next().getName()",
                data.getPetitionId(),
                data.getRelayId(),
                data.getRoles(),
                data.getScopes()
        );
    }

    private User loadUser(String docNum) {
        User user = this.userRepository
                .findByNif(docNum)
                .orElseThrow(UnauthorizedAccessException::new);

        logger.info("USER FAKE ="+user);

        if (!EntityState.ON.getValue().equals(user.getState())) {
            throw new UnauthorizedAccessException();
        }
        // Futuras comprobaciones adicionales de acceso
        return user;
    }
}

