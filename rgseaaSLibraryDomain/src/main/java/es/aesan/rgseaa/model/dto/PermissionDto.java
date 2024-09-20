package es.aesan.rgseaa.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class PermissionDto  {

    private Long id;
    private String code;
    private String name;
    private String description;
}
