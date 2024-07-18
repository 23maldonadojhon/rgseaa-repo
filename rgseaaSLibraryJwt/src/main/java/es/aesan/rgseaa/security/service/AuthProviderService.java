package es.aesan.rgseaa.security.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthProviderService {

    void authorize(HttpServletRequest request);

}
