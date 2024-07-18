package es.aesan.rgseaa.security.clave.service;

import es.aesan.rgseaa.security.clave.dto.ClaveAuthResponseData;
import es.aesan.rgseaa.security.clave.dto.ClaveRequestFormData;

import javax.servlet.http.HttpServletRequest;

public interface ClaveService {

    ClaveRequestFormData requestAuthentication();

    ClaveRequestFormData requestLogout();

    ClaveAuthResponseData processResponse(HttpServletRequest request);
}
