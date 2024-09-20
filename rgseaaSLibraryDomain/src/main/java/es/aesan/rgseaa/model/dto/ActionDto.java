package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActionDto implements Serializable {

    private Long id;

    private String description;

    private TypeActionDto typeAction;

    private List<DocumentDto> documentList;

    private Long update;

}
