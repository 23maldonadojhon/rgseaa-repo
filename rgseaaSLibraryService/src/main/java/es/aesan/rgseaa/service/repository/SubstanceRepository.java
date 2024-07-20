package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Substance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubstanceRepository
        extends BaseRepository<Substance,Long>,
        QueryByCriteria<Substance, GeneralCriteria>{


    @Query(value = "SELECT s FROM Substance s")
    List<Substance> findAll(@Param("criteria") GeneralCriteria criteria);

    @Query(value = "SELECT s FROM Substance s")
    Page<Substance> findAllByCriteria(@Param("criteria") GeneralCriteria criteria, Pageable pageable);
}
