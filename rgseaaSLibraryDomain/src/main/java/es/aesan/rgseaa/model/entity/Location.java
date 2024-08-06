package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ConstantBD.TABLE_LOCATIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Location extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENROLLMENT_PROVINCES")
    private String enrollmentProvince;

    @Column(name = "DESCRIPTION_PADRE")
    private String descriptionPadre;

    @Column(name = "COMBO")
    private Integer combo;

    @Column(name = "LOCATIONS_ID")
    private String provinceFather;

    @Column(name = "CODE_INE")
    private String codeIne;

}