package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.SituationCriteria;
import es.aesan.rgseaa.model.entity.Situation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituationRepository extends BaseRepository<Situation,Long>,
        QueryByCriteria<Situation, SituationCriteria> {

    @Query(value = "SELECT s FROM Situation s")
    Page<Situation> findAllByCriteria(SituationCriteria criteria, Pageable pageable);

    @Query(value = "SELECT s FROM Situation s " +
            " WHERE :#{#criteria.state} = s.state " +
            " AND (:#{#criteria.typeIndustryProduct} IS NULL OR s.typeIndustryProduct = :#{#criteria.typeIndustryProduct}) ")
    List<Situation> findAll(SituationCriteria criteria);
}
