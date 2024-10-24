package es.aesan.rgseaa.rest.security.service;

import es.aesan.rgseaa.rest.security.dto.JwtData;
import es.aesan.rgseaa.rest.security.dto.JwtTime;
import es.aesan.rgseaa.rest.security.dto.UserPrincipal;
import es.aesan.rgseaa.rest.security.exception.TokenNotValidException;
import es.aesan.rgseaa.rest.security.properties.JwtProperties;
import es.aesan.rgseaa.service.repository.AuthUserTokenRepository;
import io.jsonwebtoken.MalformedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthProviderImplService implements AuthProviderService {

    private static final Logger logger = LoggerFactory.getLogger(AuthProviderImplService.class);



    private final JwtService jwtService;
    private final JwtProperties jwtProperties;
    private final AuthUserTokenRepository userTokenRepository;

    @Autowired
    public AuthProviderImplService(
            JwtService jwtService,
            JwtProperties jwtProperties,
            AuthUserTokenRepository userTokenRepository
    ) {
        this.jwtService = jwtService;
        this.jwtProperties = jwtProperties;
        this.userTokenRepository = userTokenRepository;
    }

    @Override
    public void authorize(HttpServletRequest request) {
        String token = extractJWTFromRequest(request);
        if (token == null) {
            return;
        }

        try {
            validateTokenPrefix(token);
            String jwt = token.replace(this.jwtProperties.getTokenPrefix(), "").trim();
            JwtData jwtData = this.jwtService.decode(jwt);
            validateTokenIsNotForALoggedOutDevice(jwtData);

            AbstractAuthenticationToken auth = buildAuthenticationToken(jwtData);
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception e) {
            logger.error("Invalid JWT provided. Message -> [{}]", e.getMessage());
        }
    }

    private String extractJWTFromRequest(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getAuthorizationHeader());
        if (header == null || header.trim().equals("")) {
            return null;
        }
        return header;
    }

    private void validateTokenPrefix(String token) {
        if (!token.startsWith(jwtProperties.getTokenPrefix())) {
            String message = String.format("Invalid JWT provided. Token must use the prefix [%s]", jwtProperties.getTokenPrefix());
            logger.error(message);
            throw new MalformedJwtException(message);
        }
    }

    private void validateTokenIsNotForALoggedOutDevice(JwtData jwtData) {
        userTokenRepository
                .findByPetitionIdAndExpAfter(jwtData.getPetitionId(), JwtTime.now().timestamp())
                .orElseThrow(TokenNotValidException::new);
    }

    private AbstractAuthenticationToken buildAuthenticationToken(JwtData data) {
        UserDetails details = new UserPrincipal(
                data.getPetitionId(),
                data.getRelayId(),
                data.getUserId(),
                data.getDocNum(),
                data.getFirstName(),
                data.getSurnames(),
                data.getRoles(),
                data.getScopes()
        );
        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }
}
