package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryDto {

    private Long id;

    private String name;

    private String enrollment;

    private Integer noDelete;
}
