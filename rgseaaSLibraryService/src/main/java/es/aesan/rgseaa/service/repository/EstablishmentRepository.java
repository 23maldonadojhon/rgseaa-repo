package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Establishment;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends BaseRepository<Establishment,Long>,
        QueryByCriteria<Establishment, GeneralCriteria> {

}
