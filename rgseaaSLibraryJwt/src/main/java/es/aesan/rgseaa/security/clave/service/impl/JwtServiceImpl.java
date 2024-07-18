package es.aesan.rgseaa.security.clave.service.impl;

import es.aesan.rgseaa.security.clave.dto.JwtData;
import es.aesan.rgseaa.security.clave.dto.JwtTime;
import es.aesan.rgseaa.security.clave.dto.TempJwtData;
import es.aesan.rgseaa.security.clave.dto.TokenResult;
import es.aesan.rgseaa.security.clave.service.JwtService;
import es.aesan.rgseaa.security.clave.util.TokenParams;
import es.aesan.rgseaa.security.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Service
public class JwtServiceImpl implements JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    private final JwtProperties jwtProperties;
    private final Key signatureKey;

    @Autowired
    public JwtServiceImpl(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.signatureKey = Keys.hmacShaKeyFor(JwtServiceImpl.this.jwtProperties.getSecret().getBytes());
    }

    @Override
    public TokenResult buildToken(TempJwtData tokenData) {
        JwtTime exp = JwtTime.after(jwtProperties.tempTokenTTLAsTemporalAmount());
        String token = getJWTBuilder()
                .setExpiration(exp.toDate())
                .setId(tokenData.getPetitionId())
                .claim(TokenParams.RELAY_ID, tokenData.getRelayId())
                .claim(TokenParams.ROLES, tokenData.getRoles())
                .compact();
        return new TokenResult(token, jwtProperties.getTokenPrefix(), exp.timestamp());
    }

    @Override
    public TokenResult buildToken(JwtData tokenData) {
        JwtTime exp = JwtTime.after(jwtProperties.tokenTTLAsTemporalAmount());
        String token = getJWTBuilder()
                .setExpiration(exp.toDate())
                .setId(tokenData.getPetitionId())
                .setSubject(tokenData.getDocNum())
                .claim(TokenParams.USER_ID, tokenData.getUserId())
                .claim(TokenParams.FIRST_NAME, tokenData.getFirstName())
                .claim(TokenParams.SURNAMES, tokenData.getSurnames())
                .claim(TokenParams.RELAY_ID, tokenData.getRelayId())
                .claim(TokenParams.ROLES, tokenData.getRoles())
                .claim(TokenParams.SCOPES, tokenData.getScopes())
                .compact();
        return new TokenResult(token, jwtProperties.getTokenPrefix(), exp.timestamp());
    }


    @Override
    public void validate(String token) {

        logger.info("==== validate ====");

        try {
            JwtParser parser = getJWTParser();
            parser.parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            throw e;
        } catch (ExpiredJwtException ex1) {
            throw ex1;
        } catch (UnsupportedJwtException ex2) {
            throw ex2;
        } catch (IllegalArgumentException ex3) {
            throw ex3;
        }
    }

    @Override
    public JwtData decode(String token) throws JwtException {
        JwtParser parser = getJWTParser();
        Claims claims = parser.parseClaimsJws(token).getBody();
        return new JwtData(
                claims.getId(),
                claims.get(TokenParams.RELAY_ID, String.class),
                claims.get(TokenParams.USER_ID, Long.class),
                claims.getSubject(),
                claims.get(TokenParams.FIRST_NAME, String.class),
                claims.get(TokenParams.SURNAMES, String.class),
                extractClaimAsSet(claims, TokenParams.ROLES),
                extractClaimAsSet(claims, TokenParams.SCOPES)
        );
    }

    @SuppressWarnings("unchecked")
    private Set<String> extractClaimAsSet(Claims claims, String param) {
        try {
            return new HashSet<>(claims.get(param, ArrayList.class));
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    private JwtBuilder getJWTBuilder() {
        return Jwts.builder()
                .signWith(signatureKey)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(JwtTime.now().toDate());
    }

    private JwtParser getJWTParser() {
        return Jwts.parserBuilder()
                .setSigningKey(signatureKey)
                .requireIssuer(jwtProperties.getIssuer())
                .build();
    }

}
