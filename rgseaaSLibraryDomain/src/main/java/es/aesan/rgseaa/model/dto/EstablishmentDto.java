package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstablishmentDto implements Serializable {

    private Long id;
    private Long companyId;
    private String address;
    private String postalCode;
    private Long countryId;
    private Long ccaaId;
    private Long provinceId;
    private Long locationId;
    private Long situationId;
}
