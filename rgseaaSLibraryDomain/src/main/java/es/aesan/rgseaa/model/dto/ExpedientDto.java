package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ExpedientDto implements Serializable {
    private Long id;
    private String numberExpedient;
    private CompanyDto industry;
    private String nameBusiness;
    private ProductDto product;
    private DenominationSaleDto denominationSale;
    private String brand;
    private SituationDto situation;
    private KeyDto key;
    private Integer numberIndustry;
    private String addressBusiness;
    private LocalDate dateAdmission;
    private LocalDate dateEstiResolution;
    private LocalDate dateReport;
    private LocalDate dateResolution;
    private StateDto stateExpedient;
    private Integer electronicFlow;
    private CountryDto country;
    private ProvinceDto province;
    private UserDto userAssigned;
    private UserDto userReport;
    private TypeExpedientDto typeExpedient;
    private LocalDate dateAuthorization;
    private String observation;
    private String fountain;
    private String location;
    private String enrollmentKey27;
    private CountryDto countryLocation;
    private LocalDate dateDoce;
    private CountryDto countryFabrication;
    private CountryDto countryCommercialization;
    private String otherCountry;
    private String typeContainer;
    private String ingredient;
    private FormPresentationDto formPresentation;
    private String descriptionCountryLocation;
    private String socialReasonKey26;
    private String productNameIaKey26;
    private CountryDto countryIaKey26;
    private String addressKey26;
    private String emailKey26;
    private String phoneIaCode26;
    private LocalDate dateRequestChange;
    private LocalDate dateLastRequest;
    private LocalDate dateInspection;
    private LocalDate dateOfDenial;
    private LocalDate dateResponseAesan;
    private String authority;
    private TypeChangeExpedientDto typeChangeExpedient;
    private Integer productUpdated;
    private Integer signatureApplication;
    private String enrollment;
    private Integer typeSubstance;
    private String emailResponsible;
    private String industryPhone;
    private String otherCountryComer;
    private String otherForms;
    private String migration;
}
