package es.aesan.rgseaa.model.entity;


import es.aesan.rgseaa.model.commom.db.AuditedBaseEntity;
import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = ConstantBD.TABLE_DOCUMENTS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Document extends AuditedBaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "INDUSTRY_ID", referencedColumnName = "ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "TYPE_DOCUMENT_ID", referencedColumnName = "ID")
    private TypeDocument typeDocument;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ACTION_ID", referencedColumnName = "ID")
    private Action action;

    @Column(name = "CASE_FILE_ID")
    private Long caseFile;

    @Column(name = "NUMBER_EXIT")
    private Long numberExit;

    @Column(name = "PATH_FILE")
    private String pathFile;

    @Column(name = "PATH_FILE_OLD")
    private String pathFileOld;

    @Column(name = "NAME_FILE")
    private String nameFile;

}
