package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RgseaaActivityAddDto implements Serializable {

    private Long rgseaaId;
    private Long companyId;
    private Long establishmentId;
    private List<RgseaaActivityDto> rgseaaList;

}
