package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndustryAuthorizationDto implements Serializable {

    private CompanyDto companyDto;
    private AuthorizationDto authorizationDto;

}
