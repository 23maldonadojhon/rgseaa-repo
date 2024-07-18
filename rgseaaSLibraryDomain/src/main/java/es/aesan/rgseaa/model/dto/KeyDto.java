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
public class KeyDto {

    private Long id;

    private String name;

    private LocalDate dateRegister;

    private LocalDate dateUnregister;

    private Long allowProduct;

    private boolean isOld;

    private Long isPublic;

    private Integer state;
}
