package es.aesan.rgseaa.rest.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.aesan.rgseaa.model.commom.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);


    private static final String CODE = "UNAUTHORIZED";
    private static final String MESSAGE = "Please provide a valid authorization header to access this resource";
    private final ObjectMapper mapper;

    public JwtAuthenticationEntryPoint(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException e
    ) throws IOException {
        logger.error("Unauthorized access attempt [{}]. Message - [{}]", request.getRequestURI(), e.getMessage());

        try {
            ErrorDto error = new ErrorDto(CODE, e.getMessage(), MESSAGE);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().println(mapper.writeValueAsString(error));
        } catch (IOException ex) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, CODE);
        }
    }
}
