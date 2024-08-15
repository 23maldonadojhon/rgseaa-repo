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
public class CompanyEstablishmentViewDto implements Serializable {


    private Long companyId;
    private String type;
    private String nif;
    private String companyName;
    private String companyEmail;
    private String companyPageWeb;
    private String companyObservation;
    private String companyAddress;
    private String companyPostalCode;
    private Long companyCountryId;
    private Long companyProvinceId;
    private Long companyLocationId;
    private Long companySituationId;
    private Integer companyState;
    private Long establishmentId;
    private String establishmentAddress;
    private String establishmentPostalCode;
    private Long establishmentCountryId;
    private Long establishmentProvinceId;
    private Long establishmentLocationId;
    private Long establishmentSituationId;
    private Integer establishmentState;

}
