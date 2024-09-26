package es.aesan.rgseaa.model.dto;

import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProvinceDto implements Serializable {
    private Long id;
    private String name;
    private String enrollment;
    private String address;
    private CcaaDto ccaa;
}