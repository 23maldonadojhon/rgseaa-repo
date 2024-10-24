package es.aesan.rgseaa.rest.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempJwtData {
    private String petitionId;
    private String relayId;
    private Set<String> roles = new HashSet<>();
}