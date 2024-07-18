package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeFileDto {

    private Long id;

    private String name;

    private String type;

    private String typeCompanyProduct;

    private String visibleCcaa;

    private Integer noDelete;
}
