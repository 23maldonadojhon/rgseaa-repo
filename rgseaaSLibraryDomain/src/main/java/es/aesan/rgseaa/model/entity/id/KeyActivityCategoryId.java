package es.aesan.rgseaa.model.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
public class KeyActivityCategoryId implements Serializable {
    @Column(name="KEY")
    private Long key;

    @Column(name="CATEGORY")
    private Long category;

    @Column(name="ACTIVITY")
    private String activity;
}
