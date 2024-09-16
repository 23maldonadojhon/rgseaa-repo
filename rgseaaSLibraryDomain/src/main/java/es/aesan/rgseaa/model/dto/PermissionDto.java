package es.aesan.rgseaa.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class PermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    @NotBlank
    private String code;
    @NotNull
    @NotBlank
    private String name;
    private String description;
}
