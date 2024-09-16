package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Product extends AuditedBaseEntity {


    private Long id;

    private Key key;

    private String industryNum;

    private String enrollment;

    private String numProduct;

    private String numRegister;

    private Situation situation;

    private DenominationSale denominationSale;

    private String brand;

    private Entitie competentAuthority;

    private boolean requestDocumentAnnotated;

    private Long industryId;

    private String emailResponsible;

    private Country countryIndustryResponsible;

    private Long provinceIndustryResponsible;

    private Long townIndustryResponsible;

    private String addressIndustryResponsible;

    private Long codePostalResponsible;

    private Country countryManufacturingKey26;

    private Country countryCommercializedKey26;

    private FormPresentation formPresentationKey26;

    private String typePackagingKey26;

    private String observationKey26;

    private String ingredientKey26;

    private String industryNameKey26;

    private String addressKey26;

    private String emailKey26;

    private LocalDate annotatedDateKey26;

    private LocalDate lastDateKey26;

    private Country countryNotificationKey26;

    private String source;

    private String placeLocation;

    private String registrationKey27;

    private String descCountryLocation;

    private Integer countryLocation;

    private String otherCountries;

    private State stateProduct;

    private String ccaaUserCreator;

    private String socialReasonKey26;

    private String productNameIaKey26;

    private String industryPhone;

    private Long substanceType;

    private String phoneIaCode26;

    private LocalDate dateTermination;

    private LocalDate dateDenial;

    private String productType;

    private LocalDate dateRegister27;

    private LocalDate dateUnregister27;

    private LocalDate dateTermination27;

    private String otherCountriesComer;

    private String otherForms;

    private String migration;

    private String counter;

    private String migrationFolder;

    private String nameExcel;

    private LocalDate dateApplication;

    private String formattedMark;

    private Situation idSituationOld;

    private String otherCountryCompanyResp;

    private String otherCountryNotification;

    private String webPage;

    private Country countryKey26;

}
