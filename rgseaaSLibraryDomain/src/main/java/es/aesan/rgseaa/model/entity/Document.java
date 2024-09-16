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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "TYPE_DOCUMENT_ID", referencedColumnName = "ID")
    private TypeDocument typeDocument;

    @Transient
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ACTUATION_ID", referencedColumnName = "ID")
    private Actuation actuation;

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
