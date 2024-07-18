package es.aesan.rgseaa.model.dto;

import es.aesan.rgseaa.model.commom.constants.EntityState;
import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntitieDto implements LongIdModel {

    private Long id;
    private Integer state = EntityState.ON.getValue();
    private String code;
    private String name;
    private String description;
    private String postalCode;
    private String address;
    private String contactPerson;
    private String phone;
    private String email;
    private boolean rootEntity;
    private EntitieTypeDto entityType;
}
