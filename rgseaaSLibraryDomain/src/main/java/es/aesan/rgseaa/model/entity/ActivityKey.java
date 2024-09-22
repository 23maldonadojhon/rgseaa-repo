package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ConstantBD.TABLE_ACTIVITY_KEY)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ActivityKey extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "KEY_ID", referencedColumnName = "ID")
    private Key key;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID")
    private Activity activity;

}

