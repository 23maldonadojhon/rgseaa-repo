package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Key;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface KeyRepository extends BaseRepository<Key,Long>, QueryByCriteria<Key,GeneralCriteria> {

    @Query(value = "  SELECT k FROM Key k"
                    //" WHERE " +
                   // " (:#{#criteria.id} IS NULL OR k.id = :#{#criteria.id} )"
            )
    Page<Key> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Override
    @Query(value = "  SELECT k FROM Key k" +
            " WHERE  " +
            " (:#{#criteria.id} IS NULL OR k.id = :#{#criteria.id} )")
    Collection<Key> findAll(GeneralCriteria criteria);

}

