package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = ConstantBD.TABLE_AUTHORIZATIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Authorization extends AuditedBaseEntity {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
