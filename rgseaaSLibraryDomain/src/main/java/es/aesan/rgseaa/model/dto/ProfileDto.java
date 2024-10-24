package es.aesan.rgseaa.model.dto;


import es.aesan.rgseaa.model.commom.constants.EntityState;
import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto  {

    private Long id;

    private String name;

    private List<PermissionDto> permissions;

    private Integer state = EntityState.ON.getValue();

}
