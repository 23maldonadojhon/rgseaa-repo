package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = ConstantBD.TABLE_SITUATION)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Situation extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE_COMPANY_PRODUCT")
    private Long typeIndustryProduct;

    @Column(name = "NEW_OPTION")
    private Long newOption;

    @Column(name = "NO_DELETE")
    private Integer noDelete;

    @Column(name = "VISIBLE_RGSA")
    private Integer visibleRgsa;

    @Column(name = "VISIBLE_UE")
    private Integer visibleUe;

}
