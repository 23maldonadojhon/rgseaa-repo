package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.entity.id.KeyActivityCategoryId;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = ConstantBD.TABLE_KEYS_ACTIVITIES_CATEGORIES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class KeyActivityCategory {

    @EmbeddedId
    private KeyActivityCategoryId id;

    @Column(name="SUB_ACTIVITY")
    private Long subActivity;

    @Column(name="IS_VISIBLE_UE")
    private Integer isVisibleUe;

    @Column(name="IS_VISIBLE_RGSA")
    private Integer isVisibleRgsa;
}
