package es.aesan.rgseaa.model.dto;


import es.aesan.rgseaa.model.commom.constants.EntityState;
import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import lombok.Data;

import java.io.Serializable;


@Data
public class AuthorizationDto implements LongIdModel {
    private Long id;
    private String name;
    private Integer state;
}
