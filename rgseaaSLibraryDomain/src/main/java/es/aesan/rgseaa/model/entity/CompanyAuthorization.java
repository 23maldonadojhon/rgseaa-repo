package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_COMPANIES_AUTHORIZATIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CompanyAuthorization  extends AuditedBaseEntity {

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
    @JoinColumn(name = "AUTHORIZATION_ID", referencedColumnName = "ID")
    private Authorization authorization;

}
