package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.EntitieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitieTypeRepository
        extends BaseRepository<EntitieType,Long>,
        QueryByCriteria<EntitieType, GeneralCriteria> {



    @Query(value = "SELECT t FROM EntitieType t "
            + "WHERE"
            + "(COALESCE(:#{#criteria.state}, null) is null OR t.state IN (:#{#criteria.state})) "
            + "AND (:#{#criteria.name} is null OR UPPER(t.name) LIKE UPPER(:#{#criteria.name})) "
            + "AND ("
            + ":#{#criteria.search} is null "
            + "OR UPPER(t.name) LIKE UPPER(:#{#criteria.search}) "
            + ")"
    )
    Page<EntitieType> findByCriteriaPage(GeneralCriteria criteria, Pageable pageable);
}
