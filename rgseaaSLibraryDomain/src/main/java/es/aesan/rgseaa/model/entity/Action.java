package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ConstantBD.TABLE_ACTIONS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Action extends AuditedBaseEntity {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "TYPES_ACTION_ID", referencedColumnName = "ID")
    private TypeAction typeAction;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    @Column(name = "NUMBER_FILES")
    private Integer numberFiles;

    @Column(name = "TELEMATIC_REGISTER")
    private String telematicRegister;

    @Transient
    private List<Document> fileList;

}
