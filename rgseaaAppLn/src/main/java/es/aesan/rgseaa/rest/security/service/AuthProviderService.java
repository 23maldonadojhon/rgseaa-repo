package es.aesan.rgseaa.rest.security.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthProviderService {
    void authorize(HttpServletRequest request);
}
