package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_ACTIVITIES_KEYS_CATEGORIES_SUB_ACTIVITIES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ActivityKeyCategorySubActivity extends AuditedBaseEntity {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_KEY_CATEGORY_ID", referencedColumnName = "ID")
    private ActivityKeyCategory activityKeyCategory;

    @ManyToOne
    @JoinColumn(name = "SUB_ACTIVITY_ID", referencedColumnName = "ID")
    private SubActivity subActivity;
}
