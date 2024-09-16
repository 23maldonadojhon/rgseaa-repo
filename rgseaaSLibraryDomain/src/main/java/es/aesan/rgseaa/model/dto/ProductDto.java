package es.aesan.rgseaa.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProductDto implements Serializable {

    private Long id;

    private KeyDto key;
    private String industryNum;
    private String enrollment;
    private Integer numProduct;
    private Integer numRegister;
    private SituationDto situation;
    private DenominationSaleDto denominationSale;
    private String brand;
    private EntitieDto competentAuthority;
    private boolean requestDocumentAnnotated;

    private Long industryId;
    private String emailResponsible;
    private CountryDto countryIndustryResponsible;
    private String provinceIndustryResponsible;
    private String townIndustryResponsible;
    private String addressIndustryResponsible;
    private String codePostalResponsible;

    private CountryDto countryManufacturingKey26;
    private CountryDto countryCommercializedKey26;
    private FormPresentationDto formPresentationKey26;
    private String typePackagingKey26;
    private String observationKey26;
    private String ingredientKey26;
    private String industryNameKey26;
    private String addressKey26;
    private String emailKey26;
    private LocalDate annotatedDateKey26;
    private LocalDate lastDateKey26;
    private CountryDto countryNotificationKey26;

    private List<ActuationDto> action;

}
