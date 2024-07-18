package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.StandardEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_USERS_ENTITIES)
@IdClass(value = UserScopeId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntitie extends StandardEntity {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;


    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID")
    private Entitie entity;

    /**
     * Scope CODE formateado por la concatenación de todos los ID de TulsaEntity desde
     * el primer valor padre (raíz) hasta el valor actual que tenemos en esta entidad.
     * e.g. format: #1, #1#4, #1#7#n
     */
    @Column(name = "SCOPE_CODE", nullable = false, length = 20)
    private String code;


    @Override
    public void update(Object source) {
        UserEntitie s = (UserEntitie) source;

        setUser(s.getUser());
        setEntity(s.getEntity());
        setCode(s.getCode());
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

}
