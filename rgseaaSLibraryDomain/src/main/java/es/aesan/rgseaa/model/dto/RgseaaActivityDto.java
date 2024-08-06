package es.aesan.rgseaa.model.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RgseaaActivityDto implements Serializable {
    private KeyDto key;
    private ActivityDto activity;
    private CategoryDto category;
    private SubActivityDto subActivity;
}
