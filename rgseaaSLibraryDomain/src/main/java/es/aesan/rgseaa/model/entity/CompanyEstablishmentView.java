package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = ConstantBD.VIEW_COMPANIES_ESTABLISHMENTS)
@Immutable
public class CompanyEstablishmentView {

    @Id
    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;

    @Column(name = "COMPANY_PAGE_WEB")
    private String companyPageWeb;

    @Column(name = "COMPANY_OBSERVATION")
    private String companyObservation;

    @Column(name = "COMPANY_ADDRESS")
    private String companyAddress;

    @Column(name = "COMPANY_POSTAL_CODE")
    private String companyPostalCode;

    @Column(name = "COMPANY_COUNTRY_ID")
    private Long companyCountryId;

    @Column(name = "COMPANY_PROVINCE_ID")
    private Long companyProvinceId;

    @Column(name = "COMPANY_LOCATION_ID")
    private Long companyLocationId;

    @Column(name = "COMPANY_SITUATION_ID")
    private Long companySituationId;

    @Column(name = "COMPANY_STATE")
    private Integer companyState;

    @Column(name = "ESTABLISHMENT_ID")
    private Long establishmentId;

    @Column(name = "ESTABLISHMENT_ADDRESS")
    private String establishmentAddress;

    @Column(name = "ESTABLISHMENT_POSTAL_CODE")
    private String establishmentPostalCode;

    @Column(name = "ESTABLISHMENT_COUNTRY_ID")
    private Long establishmentCountryId;

    @Column(name = "ESTABLISHMENT_PROVINCE_ID")
    private Long establishmentProvinceId;

    @Column(name = "ESTABLISHMENT_LOCATION_ID")
    private Long establishmentLocationId;

    @Column(name = "ESTABLISHMENT_SITUATION_ID")
    private Long establishmentSituationId;

    @Column(name = "ESTABLISHMENT_STATE")
    private Integer establishmentState;

}
