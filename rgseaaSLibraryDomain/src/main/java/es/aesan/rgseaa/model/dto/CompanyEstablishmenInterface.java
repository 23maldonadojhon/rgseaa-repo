package es.aesan.rgseaa.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CompanyEstablishmenInterface {

    @Value("#{target.type}")
    String getType();

    @Value("#{target.company_id}")
    Long getCompanyId();

    @Value("#{target.establishment_id}")
    Long getEstablishmentId();

    @Value("#{target.company_name}")
    String getCompanyName();

    @Value("#{target.company_address}")
    String getCompanyAddress();

    @Value("#{target.establishment_address}")
    String getEstablishmentAddress();
}
