package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityDto  implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String isPublic;
}
