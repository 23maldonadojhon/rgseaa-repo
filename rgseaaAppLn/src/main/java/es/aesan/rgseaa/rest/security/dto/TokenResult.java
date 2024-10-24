package es.aesan.rgseaa.rest.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResult {
    private String token;
    private String prefix;
    private Long exp;
}