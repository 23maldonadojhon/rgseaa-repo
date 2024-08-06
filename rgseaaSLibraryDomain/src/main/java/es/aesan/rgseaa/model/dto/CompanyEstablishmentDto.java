package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyEstablishmentDto implements Serializable {
    private CompanyDto company;
    private EstablishmentDto establishment;
    private List<RgseaaActivityDto> rgseaaActivityList;
    private List<AuthorizationDto> authorizationList;
}
