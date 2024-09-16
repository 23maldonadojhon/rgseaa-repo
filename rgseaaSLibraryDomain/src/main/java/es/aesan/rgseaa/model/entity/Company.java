package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ConstantBD.TABLE_COMPANIES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Company extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PAGE_WEB")
    private String pageWeb;

    @Column(name = "OBSERVATION")
    private String observation;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "CCAA_ID", referencedColumnName = "ID")
    private Ccaa ccaa;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "SITUATION_ID", referencedColumnName = "ID")
    private Situation situation;

    @Transient
    private List<Rgseaa> rgseaaList;
}
