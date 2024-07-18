package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.entity.Entitie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitieRepository extends BaseRepository<Entitie,Long>,
        QueryByCriteria<Entitie, EntitieCriteria> {


    @Query(value = "SELECT t FROM Entitie t "
            + "WHERE "
            + " (COALESCE(:#{#criteria.state}, null) is null OR t.state IN (:#{#criteria.state})) "
            + " AND ("
            + " :#{#criteria.search} is null "
            + " OR UPPER(t.code) LIKE UPPER(:#{#criteria.search}) "
            + " OR UPPER(t.name) LIKE UPPER(:#{#criteria.search}) "
            + ")"
    )
    Page<Entitie> findAllByCriteria(@Param("criteria") EntitieCriteria criteria, Pageable pageable);
}
