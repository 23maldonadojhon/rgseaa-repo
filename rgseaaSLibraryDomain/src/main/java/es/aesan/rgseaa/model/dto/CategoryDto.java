package es.aesan.rgseaa.model.dto;


import lombok.Data;

import java.io.Serializable;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
@Data
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
}
