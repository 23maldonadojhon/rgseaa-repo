package es.aesan.rgseaa.model.commom.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class StatusChange {
    @NotNull
    @Min(1)
    private Integer status;
}
