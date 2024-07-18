package es.aesan.rgseaa.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class CategoryRef implements Serializable {

    private Long id;

}
