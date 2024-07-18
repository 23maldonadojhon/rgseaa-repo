package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyFindDto implements Serializable {
    private Long id;
    private String name;
    private String situation;
}
