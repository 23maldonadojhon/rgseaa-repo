package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CompanyDto implements Serializable {
    private Long id;
    private String nif;
    private String name;
    private String email;
    private String pageWeb;
    private String observation;
    private String address;
    private String postalCode;
    private Long ccaaId;
    private Long countryId;
    private Long provinceId;
    private Long locationId;
    private Long situationId;
    private List<AuthorizationDto> authorizationList;
    private List<RgseaaActivityDto> rgseaaList;
    private List<ActuationDto> actuationList;
}


