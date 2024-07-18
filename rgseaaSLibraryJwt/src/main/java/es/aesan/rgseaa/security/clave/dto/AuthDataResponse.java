package es.aesan.rgseaa.security.clave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDataResponse {
    private String token;
    private Long exp;
}
