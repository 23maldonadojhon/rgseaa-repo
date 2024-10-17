package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.TypeDocumentCriteria;
import es.aesan.rgseaa.model.entity.TypeDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TypeDocumentRepository
        extends BaseRepository<TypeDocument,Long>,
        QueryByCriteria<TypeDocument,TypeDocumentCriteria> {

    @Override
    @Query(value = "SELECT t FROM TypeDocument t" +
        " WHERE " +
        " :#{#criteria.state} = t.state " +
        " AND (:#{#criteria.typeCompanyProduct} IS NULL OR t.typeCompanyProduct = :#{#criteria.typeCompanyProduct})")
    Page<TypeDocument> findAllByCriteria(TypeDocumentCriteria criteria, Pageable pageable);


    @Override
    @Query(value = "SELECT t FROM TypeDocument t" +
        " WHERE " +
        " :#{#criteria.state} = t.state " +
        " AND (:#{#criteria.typeCompanyProduct} IS NULL OR t.typeCompanyProduct = :#{#criteria.typeCompanyProduct})")
    Collection<TypeDocument> findAll(TypeDocumentCriteria criteria);

}
