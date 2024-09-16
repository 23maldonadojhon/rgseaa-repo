package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author serikat
 */
@Entity
@Table(name = ConstantBD.TABLE_USERS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class User extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NIF", unique = true, length = 9)
    private String nif;

    @Column(name = "NAME" )
    private String name;

    @Column(name = "FIRST_SURNAME")
    private String firstSurname;

    @Column(name = "SECOND_SURNAME")
    private String secondSurname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne
    @JoinColumn(name= "PROFILE_ID", referencedColumnName = "ID")
    private Profile profile;

    @Transient
    private Set<UserModule> modules;

    @Transient
    private Set<UserEntitie> entitie;

}

