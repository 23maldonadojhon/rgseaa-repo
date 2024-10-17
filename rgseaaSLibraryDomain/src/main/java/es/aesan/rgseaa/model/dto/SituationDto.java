package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SituationDto {

    private Long id;

    private String name;

    private Long typeIndustryProduct;

    private Integer visibleRgsa;

    private Integer visibleUe;
}
