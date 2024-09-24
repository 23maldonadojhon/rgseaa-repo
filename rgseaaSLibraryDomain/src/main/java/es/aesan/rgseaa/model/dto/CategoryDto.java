package es.aesan.rgseaa.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDto implements Serializable {
    private Long id;
    private String code;
    private String name;
    private List<KeyActivityDto> keyActivity;
}
