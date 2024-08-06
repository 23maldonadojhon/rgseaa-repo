package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentDto;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyEstablishmentViewRepository
    extends BaseRepository<CompanyEstablishmentView, Long>,
    QueryByCriteria<CompanyEstablishmentView, GeneralCriteria> {


    @Query( value = "SELECT c.* FROM COMPANIES_ESTABLISHMENTS_VIEW c" +
            " WHERE "+
            " :#{#criteria.search} IS NULL " +
            "  OR UPPER(c.COMPANY_NAME) LIKE UPPER(:#{#criteria.search}) " +
            "  OR UPPER(c.COMPANY_ADDRESS) LIKE UPPER(:#{#criteria.search}) " +
            "  OR UPPER(c.ESTABLISHMENT_ADDRESS) LIKE UPPER(:#{#criteria.search}) ",
            nativeQuery = true)
    Page<CompanyEstablishmenInterface> findCriteria(@Param("criteria") GeneralCriteria criteria, Pageable pageable);
}
