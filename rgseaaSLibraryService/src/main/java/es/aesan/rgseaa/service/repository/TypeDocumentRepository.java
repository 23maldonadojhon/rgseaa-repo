package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeDocumentRepository
        extends BaseRepository<TypeDocument,Long>,
        QueryByCriteria<TypeDocument,GeneralCriteria> {

    @Query(value = "SELECT t FROM TypeDocument t")
    Page<TypeDocument> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Query(value = "SELECT t FROM TypeDocument t")
    List<TypeDocument> findAll(GeneralCriteria criteria);

}
