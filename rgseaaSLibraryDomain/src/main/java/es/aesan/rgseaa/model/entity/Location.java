package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_LOCATIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Location extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION_PADRE")
    private String descriptionPadre;

    @Column(name = "COMBO")
    private Integer combo;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

    @Column(name = "INE_CODE")
    private String ineCode;

}