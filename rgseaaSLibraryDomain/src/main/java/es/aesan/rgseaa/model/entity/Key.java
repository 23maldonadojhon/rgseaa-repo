package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = ConstantBD.TABLE_KEYS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Key extends AuditedBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="ID")
    private Long id;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;


    @Column(name="DATE_REGISTER")
    private LocalDate dateRegister;

    @Column(name="DATE_UNREGISTER")
    private LocalDate dateUnregister;

    @Column(name="ALLOW_PRODUCT")
    private Long allowProduct;

    @Column(name="IS_OLD")
    private Long isOld;

    @Column(name="IS_PUBLIC")
    private Long isPublic;



/*
     @Column(name = "STATE")
    private long state;

     @PrePersist
    protected void onCreate() {
        this.state = 1;
    }*/

}
