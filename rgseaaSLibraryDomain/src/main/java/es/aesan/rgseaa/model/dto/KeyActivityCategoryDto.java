package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class KeyActivityCategoryDto implements Serializable {
    private KeyDto key;
    private CategoryDto category;
    private ActivityDto activity;
    private SubActivityDto subActivity;
}
