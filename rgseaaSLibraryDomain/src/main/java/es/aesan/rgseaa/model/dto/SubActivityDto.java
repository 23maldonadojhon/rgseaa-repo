package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubActivityDto implements Serializable {
    private Long id;
    private String code;
    private String name;
}
