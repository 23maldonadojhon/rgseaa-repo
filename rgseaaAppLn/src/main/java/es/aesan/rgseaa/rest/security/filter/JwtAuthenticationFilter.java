package es.aesan.rgseaa.rest.security.filter;

import es.aesan.rgseaa.rest.security.service.AuthProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


    private final AuthProviderService authProviderService;

    public JwtAuthenticationFilter(AuthProviderService authProviderService) {
        this.authProviderService = authProviderService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        logger.info("Initializing internal filter");
        authProviderService.authorize(request);
        logger.info("Completing request filter");
        filterChain.doFilter(request, response);
        logger.info("Completed internal filter");
    }
}