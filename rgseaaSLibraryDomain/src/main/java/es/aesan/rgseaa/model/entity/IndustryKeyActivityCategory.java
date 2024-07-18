package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_INDUSTRIES_KEYS_ACTIVITIES_CATEGORIES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class IndustryKeyActivityCategory extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_INDUSTRY")
    private Long idIndustry;

    @Column(name = "ID_KEY")
    private Long idKey;

    @Column(name = "ID_CATEGORY")
    private Long idCategory;

    @Column(name = "CODE_ACTIVITY")
    private String codeActivity;

    @Column(name = "ID_SUB_ACTIVITY")
    private Long idSubActivity;


    @Transient
    private Key key;

    @Transient
    private Activity activity;

    @Transient
    private Category category;

    @Transient
    private SubActivity subActivity;

}


