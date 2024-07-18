package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B64EncodedFileDto implements Serializable {
    private String data;
    private String dataUrl;
    private String name;
    private String type;
    private Integer size;
}
