package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeDocumentDto implements Serializable {

    private Long id;

    private String type;

    private String name;

    private Integer visible;

    private Integer noDelete;
}
