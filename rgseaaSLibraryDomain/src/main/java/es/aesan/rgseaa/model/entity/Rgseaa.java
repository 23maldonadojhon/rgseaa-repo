package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = ConstantBD.TABLE_RGSEAA)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Rgseaa extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "ESTABLISHMENT_ID", referencedColumnName = "ID")
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "KEY_ID", referencedColumnName = "ID")
    private Key key;

    @Column(name = "NUM_RGSEAA")
    private String numRgseaa;

    @Column(name = "ENROLLMENT")
    private String  enrollment;

    @Column(name = "DATE_REGISTER")
    private LocalDate dateRegister;

    @Column(name = "DATE_ANNOTATION")
    private LocalDate dateAnnotation;

    @Column(name = "DATE_MODIFICATION")
    private LocalDate dateModification;
}
