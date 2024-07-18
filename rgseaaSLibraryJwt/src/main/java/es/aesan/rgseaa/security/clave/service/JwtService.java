package es.aesan.rgseaa.security.clave.service;


import es.aesan.rgseaa.security.clave.dto.JwtData;
import es.aesan.rgseaa.security.clave.dto.TempJwtData;
import es.aesan.rgseaa.security.clave.dto.TokenResult;
import io.jsonwebtoken.JwtException;

public interface JwtService {

    TokenResult buildToken(TempJwtData tokenData);

    TokenResult buildToken(JwtData tokenData);

    void validate(String token) throws JwtException;

    JwtData decode(String token) throws JwtException;
}
