package es.aesan.rgseaa.security.clave.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignInPetitionResp {
    private String petitionId;
    private String relayId;
    private String tempToken;
    private ClaveRequestFormData authData;
}