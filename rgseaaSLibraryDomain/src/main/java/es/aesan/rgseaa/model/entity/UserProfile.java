package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_USERS_PROFILES)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserProfile extends AuditedBaseEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;


    @ManyToOne(optional = false)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private Profile profile;
}
