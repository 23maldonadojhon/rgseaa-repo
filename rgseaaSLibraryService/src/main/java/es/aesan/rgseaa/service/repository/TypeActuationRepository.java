package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.TypeActuationCriteria;
import es.aesan.rgseaa.model.entity.TypeActuation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TypeActuationRepository
        extends BaseRepository<TypeActuation,Long>,
        QueryByCriteria<TypeActuation, TypeActuationCriteria> {

    @Query(value = "SELECT t FROM TypeActuation t")
    Page<TypeActuation> findAllByCriteria(TypeActuationCriteria criteria, Pageable pageable);

    @Override
    @Query(value = " SELECT t FROM TypeActuation t " +
            " WHERE :#{#criteria.state} = t.state " +
            " AND (:#{#criteria.typeIndustryProduct} IS NULL OR t.typeIndustryProduct = :#{#criteria.typeIndustryProduct}) ")
    Collection<TypeActuation> findAll(TypeActuationCriteria criteria);
}
