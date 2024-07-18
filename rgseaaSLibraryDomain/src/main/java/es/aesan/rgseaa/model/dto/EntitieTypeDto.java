package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntitieTypeDto {

    private Long id;
    private Long languageId;
    @NotNull()
    @NotBlank()
    private String name;
    private String description;
    private Integer state;
}
