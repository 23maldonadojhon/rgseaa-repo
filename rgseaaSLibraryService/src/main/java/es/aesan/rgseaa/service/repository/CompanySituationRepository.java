package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.CompanySituation;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySituationRepository
        extends BaseRepository<CompanySituation,Long>,
        QueryByCriteria<CompanySituation, GeneralCriteria> {


}
