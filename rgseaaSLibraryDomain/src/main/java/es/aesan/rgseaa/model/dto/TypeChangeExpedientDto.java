package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeChangeExpedientDto  implements Serializable {
    private int id;
    private String name;
}
