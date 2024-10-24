package es.aesan.rgseaa.rest.security.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JwtData extends TempJwtData {
    private Long userId;
    private String docNum;
    private String firstName;
    private String surnames;
    private Set<String> scopes = new HashSet<>();


    public JwtData(
            String petitionId,
            String relayId,
            Long userId,
            String docNum,
            String firstName,
            String surnames,
            Set<String> roles,
            Set<String> scopes
    ) {
        super(petitionId, relayId, roles);
        this.userId = userId;
        this.docNum = docNum;
        this.firstName = firstName;
        this.surnames = surnames;
        this.scopes = scopes;
    }

    public String getFullName() {
        return firstName + " " + surnames;
    }
}