package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KeyDto implements Serializable {

    private Long id;

    private String name;

    private Long code;

    private Long allowProduct;

    private boolean isOld;

    private Long isPublic;


}
