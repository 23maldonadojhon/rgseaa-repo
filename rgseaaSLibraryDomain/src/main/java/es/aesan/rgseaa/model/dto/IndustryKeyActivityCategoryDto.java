package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class IndustryKeyActivityCategoryDto implements Serializable {
    private Long id;
    private KeyDto key;
    private CategoryDto category;
    private ActivityDto activity;
    private SubActivityDto subActivity;
}
