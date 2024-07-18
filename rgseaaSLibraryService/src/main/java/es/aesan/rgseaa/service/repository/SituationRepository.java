package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Situation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituationRepository extends BaseRepository<Situation,Long>, QueryByCriteria<Situation, GeneralCriteria> {

    @Query(value = "SELECT s FROM Situation s")
    Page<Situation> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Query(value = "SELECT s FROM Situation s")
    List<Situation> findAll(GeneralCriteria criteria);
}
