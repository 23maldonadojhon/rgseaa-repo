package es.aesan.rgseaa.security.clave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDetails {
    private Long userId;
    private String docNum;

    private String firstName;
    private String firstSurname;
    private String secondSurname;

    private String profile;
    private String petitionId;
    private String relayId;

    private Set<String> roles;
    private Set<String> scopes;
}
