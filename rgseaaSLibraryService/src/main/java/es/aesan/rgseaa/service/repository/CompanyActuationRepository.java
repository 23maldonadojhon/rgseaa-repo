package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.CompanyActuationCriteria;
import es.aesan.rgseaa.model.entity.CompanyActuation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyActuationRepository
        extends BaseRepository<CompanyActuation,Long>,
         QueryByCriteria<CompanyActuation, CompanyActuationCriteria>{

    @Override
    @Query(" SELECT c FROM CompanyActuation c" +
            " WHERE " +
            "(:#{#criteria.state} IS NULL OR c.state = :#{#criteria.state}) " +
            " AND (:#{#criteria.companyId} IS NULL OR c.company.id = :#{#criteria.companyId})")
    List<CompanyActuation> findAll(CompanyActuationCriteria criteria);
}
