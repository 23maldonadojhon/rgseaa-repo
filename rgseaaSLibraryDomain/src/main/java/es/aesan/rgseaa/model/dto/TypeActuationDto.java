package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class TypeActuationDto implements Serializable {

    private Long id;
    private String name;
    private Integer visible;
    private Long typeIndustry;
}
