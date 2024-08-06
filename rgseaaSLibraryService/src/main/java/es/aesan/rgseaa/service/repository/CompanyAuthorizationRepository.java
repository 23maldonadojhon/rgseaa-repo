package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.CompanyAuthorizationCriteria;
import es.aesan.rgseaa.model.entity.CompanyAuthorization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAuthorizationRepository
        extends BaseRepository<CompanyAuthorization,Long>,
        QueryByCriteria<CompanyAuthorization, CompanyAuthorizationCriteria>{


    @Query(value = "SELECT a FROM CompanyAuthorization a" +
            " WHERE " +
            " (:#{#criteria.companyId} IS NULL OR a.company.id = :#{#criteria.companyId}) "
    )
    List<CompanyAuthorization> findAll(CompanyAuthorizationCriteria criteria);

}
