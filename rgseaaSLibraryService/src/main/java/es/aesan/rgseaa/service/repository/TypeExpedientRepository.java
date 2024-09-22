package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeExpedient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TypeExpedientRepository
        extends BaseRepository<TypeExpedient, Long>,
        QueryByCriteria<TypeExpedient, GeneralCriteria> {

    @Override
    @Query(value =  " SELECT d FROM TypeExpedient d " +
            " WHERE " +
            " (:#{#criteria.id} IS NULL OR d.id = :#{#criteria.id} )")
    Page<TypeExpedient> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Override
    @Query(value =  " SELECT d FROM TypeExpedient d ")
    Collection<TypeExpedient> findAll(GeneralCriteria criteria);

}
