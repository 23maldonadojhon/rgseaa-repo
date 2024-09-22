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

    private KeyDto key;

    private ActivityDto activity;

    private TypeExpedientDto typeExpedient;

    private Integer isPublic;

    private Integer state;
}
