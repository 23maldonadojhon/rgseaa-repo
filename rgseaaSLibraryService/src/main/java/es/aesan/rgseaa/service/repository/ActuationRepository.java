package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.entity.Actuation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActuationRepository
        extends BaseRepository<Actuation,Long>,
         QueryByCriteria<Actuation, ActuationCriteria>{

    @Override
    @Query(" SELECT c FROM Actuation c" +
            " WHERE " +
            "(:#{#criteria.state} IS NULL OR c.state = :#{#criteria.state}) " +
            " AND (:#{#criteria.companyId} IS NULL OR c.company.id = :#{#criteria.companyId})" +
            " AND (:#{#criteria.establishmentId} IS NULL OR c.establishment.id = :#{#criteria.establishmentId})")
    List<Actuation> findAll(ActuationCriteria criteria);
}
