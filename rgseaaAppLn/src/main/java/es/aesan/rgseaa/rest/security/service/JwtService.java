package es.aesan.rgseaa.rest.security.service;

import es.aesan.rgseaa.rest.security.dto.JwtData;
import es.aesan.rgseaa.rest.security.dto.TempJwtData;
import es.aesan.rgseaa.rest.security.dto.TokenResult;
import io.jsonwebtoken.JwtException;


public interface JwtService {

    TokenResult buildToken(TempJwtData tokenData);

    TokenResult buildToken(JwtData tokenData);

    void validate(String token) throws JwtException;

    JwtData decode(String token) throws JwtException;

}
