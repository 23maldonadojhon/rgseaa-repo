package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.entity.id.Company;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ConstantBD.TABLE_ACTIVITY_KEY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ActivityKey extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "KEY_ID", referencedColumnName = "ID")
    private Key key;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID")
    private Activity activity;


    @ElementCollection
    @CollectionTable(name = "ACTIVITIES_KEYS_CATEGORIES", joinColumns = @JoinColumn(name = "ACTIVITIES_KEYS_ID"))
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "CATEGORY_ID"))
    })
    private List<CategoryRef> categories;

    /*
    @ElementCollection
    @CollectionTable(name = "ACTIVITIES_KEYS_SUB_CATEGORIES", joinColumns = @JoinColumn(name = "ACTIVITIES_KEYS_ID"))
    private List<SubCategoryRef> subCategories;
*/
}

