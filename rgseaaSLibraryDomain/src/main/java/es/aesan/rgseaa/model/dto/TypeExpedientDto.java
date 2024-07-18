package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeExpedientDto  implements Serializable {
    private int id;
    private String name;
    private String code;
}
