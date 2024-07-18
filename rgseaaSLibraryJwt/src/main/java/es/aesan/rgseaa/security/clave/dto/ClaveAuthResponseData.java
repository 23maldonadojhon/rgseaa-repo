package es.aesan.rgseaa.security.clave.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClaveAuthResponseData {
    private String docNum;
    private String relayId;
    private String firstName;
    private String surnames;

    public String getFullName() {
        return firstName + " " + surnames;
    }
}
