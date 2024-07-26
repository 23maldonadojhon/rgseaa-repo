package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeActuation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface TypeActuationRepository
        extends BaseRepository<TypeActuation,Long>,
        QueryByCriteria<TypeActuation,GeneralCriteria> {

    @Query(value = "SELECT t FROM TypeActuation t")
    Page<TypeActuation> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

}
