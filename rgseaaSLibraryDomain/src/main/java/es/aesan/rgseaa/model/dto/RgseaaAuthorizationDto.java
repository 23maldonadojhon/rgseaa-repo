package es.aesan.rgseaa.model.dto;


import es.aesan.rgseaa.model.entity.Authorization;
import es.aesan.rgseaa.model.entity.Rgseaa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RgseaaAuthorizationDto {
    private Long id;
    private RgseaaDto rgseaa;
    private AuthorizationDto authorization;
}
