package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_RGSEAA)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Rgseaa {

    @Id
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
}
