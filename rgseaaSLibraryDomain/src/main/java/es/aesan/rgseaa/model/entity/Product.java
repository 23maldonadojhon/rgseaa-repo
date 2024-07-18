package es.aesan.rgseaa.model.entity;



import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = ConstantBD.TABLE_PRODUCTS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Product extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_KEY", referencedColumnName = "ID")
    private Key key;

    @Column(name = "INDUSTRY_NUM")
    private String industryNum;

    @Column(name = "ENROLLMENT")
    private String enrollment;

    @Column(name = "NUM_PRODUCT")
    private String numProduct;

    @Column(name = "NUM_REG_CCAA")
    private String numRegister;

    @ManyToOne
    @JoinColumn(name = "ID_SITUATION", referencedColumnName = "ID")
    private Situation situation;

    @ManyToOne
    @JoinColumn(name = "ID_DENOMINATION_SALE", referencedColumnName = "ID")
    private DenominationSale denominationSale;

    @Column(name = "BRAND")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "ID_COMPETENT_AUTHORITY", referencedColumnName = "ID")
    private Entitie competentAuthority;

    @Transient
    private boolean requestDocumentAnnotated;

    @Column(name = "ID_INDUSTRY")
    private Long industryId;

    @Column(name = "INDUSTRY_EMAIL")
    private String emailResponsible;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY_COMPANY_RESP", referencedColumnName = "ID")
    private Country countryIndustryResponsible;

    @Transient
    private Long provinceIndustryResponsible;

    @Transient
    private Long townIndustryResponsible;

    @Column(name = "INDUSTRY_ADDRESS")
    private String addressIndustryResponsible;

    @Transient
    private Long codePostalResponsible;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY_MANUFACTURING", referencedColumnName = "ID")
    private Country countryManufacturingKey26;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY_MARKETING", referencedColumnName = "ID")
    private Country countryCommercializedKey26;

    @ManyToOne
    @JoinColumn(name = "ID_FORM_PRESENTATION", referencedColumnName = "ID")
    private FormPresentation formPresentationKey26;

    @Column(name = "TYPE_PACKAGING")
    private String typePackagingKey26;

    @Column(name = "OBSERVATION")
    private String observationKey26;

    @Column(name = "INGREDIENTS")
    private String ingredientKey26;

    @Column(name = "INDUSTRY_NAME")
    private String industryNameKey26;

    @Column(name = "ADDRESS_IA_CODE_26")
    private String addressKey26;

    @Column(name = "EMAIL_CODE_26")
    private String emailKey26;

    @Column(name = "CREATED_AT_NOT")
    private LocalDate annotatedDateKey26;

    @Column(name = "DATE_LAST_ACTUATION")
    private LocalDate lastDateKey26;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY_NOTIFICATION", referencedColumnName = "ID")
    private Country countryNotificationKey26;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "PLACE_LOCATION")
    private String placeLocation;

    @Column(name = "REGISTRATION_KEY_27")
    private String registrationKey27;

    @Column(name = "DESC_COUNTRY_LOCATION")
    private String descCountryLocation;

    @Column(name = "COUNTRY_LOCATION")
    private Integer countryLocation;

    @Column(name = "OTHER_COUNTRIES")
    private String otherCountries;

    @ManyToOne
    @JoinColumn(name = "ID_STATE_PRODUCT", referencedColumnName = "ID")
    private State stateProduct;

    @Column(name = "CCAA_USER_CREATOR")
    private String ccaaUserCreator;

    @Column(name = "SOCIAL_REASON_KEY_26")
    private String socialReasonKey26;

    @Column(name = "PRODUCT_NAME_IA_KEY_26")
    private String productNameIaKey26;

    @Column(name = "INDUSTRY_PHONE")
    private String industryPhone;

    @Column(name = "SUBSTANCE_TYPE")
    private Long substanceType;

    @Column(name = "PHONE_IA_CODE_26")
    private String phoneIaCode26;

    @Column(name = "DATE_TERMINATION")
    private LocalDate dateTermination;

    @Column(name = "DATE_DENIAL")
    private LocalDate dateDenial;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "DATE_REGISTER_27")
    private LocalDate dateRegister27;

    @Column(name = "DATE_UNREGISTER_27")
    private LocalDate dateUnregister27;

    @Column(name = "DATE_TERMINATION_27")
    private LocalDate dateTermination27;

    @Column(name = "OTHER_COUNTRIES_COMER")
    private String otherCountriesComer;

    @Column(name = "OTHER_FORMS")
    private String otherForms;

    @Column(name = "MIGRATION")
    private String migration;

    @Column(name = "COUNTER")
    private String counter;

    @Column(name = "MIGRATION_FOLDER")
    private String migrationFolder;

    @Column(name = "NAME_EXCEL")
    private String nameExcel;

    @Column(name = "DATE_APPLICATION")
    private LocalDate dateApplication;

    @Column(name = "FORMATTED_MARK")
    private String formattedMark;

    @ManyToOne
    @JoinColumn(name = "ID_SITUATION_OLD", referencedColumnName = "ID")
    private Situation idSituationOld;

    @Column(name = "OTHER_COUNTRY_COMPANY_RESP")
    private String otherCountryCompanyResp;

    @Column(name = "OTHER_COUNTRY_NOTIFICATION")
    private String otherCountryNotification;

    @Column(name = "WEB_PAGE")
    private String webPage;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY_IA_KEY_26", referencedColumnName = "ID")
    private Country countryKey26;

    @Transient
    private List<Action> action;
}
