package es.aesan.rgseaa.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CompanyEstablishmenInterface {

    @Value("#{target.TYPE}")
    String getType();

    @Value("#{target.NIF}")
    String getNif();

    @Value("#{target.COMPANY_ID}")
    Long getCompanyId();

    @Value("#{target.COMPANY_NAME}")
    String getCompanyName();

    @Value("#{target.COMPANY_ADDRESS}")
    String getCompanyAddress();

    @Value("#{target.COMPANY_POSTAL_CODE}")
    String getCompanyPostalCode();

    @Value("#{target.COMPANY_CCAA_NAME}")
    String getCompanyCcaaName();

    @Value("#{target.COMPANY_COUNTRY_NAME}")
    String getCompanyCountryName();

    @Value("#{target.COMPANY_PROVINCE_NAME}")
    String getCompanyProvinceName();

    @Value("#{target.COMPANY_LOCATION_NAME}")
    String getCompanyLocationName();

    @Value("#{target.COMPANY_SITUATION_NAME}")
    String getCompanySituationName();

    @Value("#{target.COMPANY_STATE}")
    String getCompanyState();

    @Value("#{target.ESTABLISHMENT_ID}")
    Long getEstablishmentId();

    @Value("#{target.ESTABLISHMENT_ADDRESS}")
    String getEstablishmentAddress();

    @Value("#{target.ESTABLISHMENT_POSTAL_CODE}")
    String getEstablishmentPostalCode();

    @Value("#{target.ESTABLISHMENT_COUNTRY_NAME}")
    String getEstablishmentCountryName();

    @Value("#{target.ESTABLISHMENT_CCAA_NAME}")
    String getEstablishmentCcaaName();

    @Value("#{target.ESTABLISHMENT_PROVINCE_NAME}")
    String getEstablishmentProvinceName();

    @Value("#{target.ESTABLISHMENT_LOCATION_NAME}")
    String getEstablishmentLocationName();

    @Value("#{target.ESTABLISHMENT_SITUATION_NAME}")
    String getEstablishmentSituationName();
}
