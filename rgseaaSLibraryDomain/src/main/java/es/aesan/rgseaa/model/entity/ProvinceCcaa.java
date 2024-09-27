package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_USERS_PROFILES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ProvinceCcaa extends AuditedBaseEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;


    @ManyToOne(optional = false)
    @JoinColumn(name = "CCAA_ID", referencedColumnName = "ID")
    private Ccaa ccaa;
}
