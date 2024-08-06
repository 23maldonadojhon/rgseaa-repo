package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = ConstantBD.TABLE_DENOMINATION_SALE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class DenominationSale extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "KEY_ID", referencedColumnName = "ID")
    private Key key;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID")
    private Activity activity;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Column(name = "IS_PUBLIC")
    private Integer isPublic;

    @Column(name = "DATE_REGISTER")
    private LocalDate dateRegister;

    @Column(name = "DATE_UNREGISTER")
    private LocalDate dateUnregister;

    @Column(name = "ACTIVE")
    private Integer active;

}
