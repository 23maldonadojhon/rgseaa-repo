package es.aesan.rgseaa.security.clave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ClaveRequestFormData {
    private String authUrl;
    private String relayId;
    private Map<String, String> authParams;
}
