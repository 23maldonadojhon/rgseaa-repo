package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.DocumentCriteria;
import es.aesan.rgseaa.model.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository extends BaseRepository<Document,Long>,
        QueryByCriteria<Document, DocumentCriteria> {


    @Query(value = "SELECT d FROM Document d")
    Page<Document> findAllByCriteria(DocumentCriteria criteria, Pageable pageable);


    @Query(value = " SELECT d FROM Document d " +
            " WHERE " +
            " (:#{#criteria.actuationId} is null or d.actuation.id = :#{#criteria.actuationId}) "
    )
    List<Document> findAll(DocumentCriteria criteria);
}