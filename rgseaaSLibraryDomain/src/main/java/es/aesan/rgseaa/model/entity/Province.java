package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_PROVINCES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Province extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENROLLMENT")
    private String enrollment;

    @Column(name = "PRE_POSTAL_CODE")
    private String prePostalCode;

    @Column(name = "ENROLLMENT_CCAA")
    private String enrollmentCCAA;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "OLD")
    private Integer old;

    @Column(name = "OLD_TWO")
    private Integer oldTwo;

    @Column(name = "OLD_THREE")
    private Integer oldThree;
}
