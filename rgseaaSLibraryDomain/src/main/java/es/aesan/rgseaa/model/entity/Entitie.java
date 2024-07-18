package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_ENTITIES)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entitie  extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROOT_ENTITY")
    private boolean rootEntity = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_TYPE", referencedColumnName = "ID")
    private EntitieType entityType;

}
