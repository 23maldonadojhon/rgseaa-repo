package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_RGSEAA_AUTHORIZATIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RgseaaAuthorization extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RGSEAA_ID", referencedColumnName = "ID")
    private Rgseaa rgseaa;

    @ManyToOne
    @JoinColumn(name = "AUTHORIZATION_ID", referencedColumnName = "ID")
    private Authorization authorization;

}
