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
public class RgseaaActivityDto implements Serializable {
    private Long id;
    private KeyDto key;
    private ActivityDto activity;
    private CategoryDto category;
    private SubActivityDto subActivity;
}
