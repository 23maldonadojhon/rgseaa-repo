package es.aesan.rgseaa.model.dto;


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
