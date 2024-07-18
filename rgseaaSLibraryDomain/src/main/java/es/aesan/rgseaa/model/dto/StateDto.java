package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StateDto implements Serializable {
    private int id;
    private String code;
    private String name;
}
