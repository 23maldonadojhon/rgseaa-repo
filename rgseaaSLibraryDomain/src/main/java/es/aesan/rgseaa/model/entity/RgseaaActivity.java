package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.entity.id.Company;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_RGSEAA_ACTIVITY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class RgseaaActivity {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RGSEAA_ID", referencedColumnName = "ID")
    private Rgseaa rgseaa;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUB_ACTIVITY_ID", referencedColumnName = "ID")
    private SubActivity subActivity;
}
