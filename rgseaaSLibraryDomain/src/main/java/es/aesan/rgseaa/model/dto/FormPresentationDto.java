package es.aesan.rgseaa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormPresentationDto {

    private Long id;

    private String name;

    private String type;

    private LocalTime dateRegister;

    private LocalTime dateUnregister;

}
