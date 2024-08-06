package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ConstantBD.TABLE_ENTITIES_TYPES)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EntitieType extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

}
