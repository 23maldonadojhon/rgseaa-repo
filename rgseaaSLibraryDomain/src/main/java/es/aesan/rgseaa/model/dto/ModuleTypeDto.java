package es.aesan.rgseaa.model.dto;


import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleTypeDto implements LongIdModel, Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long languageId;
    private Integer state;
    @NotNull()
    @NotBlank()
    private String name;
    private String description;
}

