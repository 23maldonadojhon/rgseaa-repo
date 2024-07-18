package es.aesan.rgseaa.security.clave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthDataRecoveryReq {
    @NotNull
    @NotBlank
    private String petitionId;
    @NotNull
    @NotBlank
    private String relayId;
    @NotNull
    @NotBlank
    private String tempToken;

    @Override
    public String toString() {
        return "AuthDataRecoveryReq{" +
                "petitionId='" + petitionId + '\'' +
                ", relayId='" + relayId + '\'' +
                '}';
    }
}