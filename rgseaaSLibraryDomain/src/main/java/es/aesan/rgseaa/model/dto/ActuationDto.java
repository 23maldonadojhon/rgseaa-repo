package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActuationDto implements Serializable {

    private Long id;
    private String description;
    private TypeActuationDto typeActuation;
    private List<DocumentDto> documentList;
    private Long update;
    private boolean saved;

}
