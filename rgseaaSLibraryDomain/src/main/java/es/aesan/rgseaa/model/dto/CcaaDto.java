package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CcaaDto implements Serializable {
    private Long id;
    private String name;
    private String enrollment;
}