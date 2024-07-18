package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DenominationSaleDto {

    private Long id;

    private String name;

    private Long idKey;

    private String fileType;

    private String idActivity;

    private Integer isPublic;

    private LocalDate dateRegister;

    private LocalDate dateUnregister;

    private Integer active;

    private Integer state;
}
