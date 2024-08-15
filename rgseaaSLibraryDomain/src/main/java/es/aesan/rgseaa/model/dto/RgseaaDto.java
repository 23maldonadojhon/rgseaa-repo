package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RgseaaDto implements Serializable {
    private Long id;
    private Long companyId;
    private Long keyId;
    private KeyDto key;
    private Long establishmentId;
    private String numRgseaa;
    private String enrollment;
}
