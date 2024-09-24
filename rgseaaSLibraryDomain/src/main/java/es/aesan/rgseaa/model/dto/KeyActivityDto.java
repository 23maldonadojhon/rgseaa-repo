package es.aesan.rgseaa.model.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class KeyActivityDto implements Serializable {
    private Long id;
    private KeyDto key;
    private ActivityDto activity;
}
