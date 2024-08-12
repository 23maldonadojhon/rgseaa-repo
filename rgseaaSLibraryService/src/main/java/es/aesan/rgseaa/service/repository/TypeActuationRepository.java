package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.entity.TypeActuation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TypeActuationRepository
        extends BaseRepository<TypeActuation,Long>,
        QueryByCriteria<TypeActuation,ActuationCriteria> {

    @Query(value = "SELECT t FROM TypeActuation t")
    Page<TypeActuation> findAllByCriteria(ActuationCriteria criteria, Pageable pageable);

    @Override
    @Query(value = "SELECT t FROM TypeActuation t")
    Collection<TypeActuation> findAll(ActuationCriteria criteria);
}
