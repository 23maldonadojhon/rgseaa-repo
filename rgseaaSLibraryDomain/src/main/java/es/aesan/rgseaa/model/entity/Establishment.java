package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_ESTABLISHMENTS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Establishment extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "SITUATION_ID", referencedColumnName = "ID")
    private Situation situation;
}
