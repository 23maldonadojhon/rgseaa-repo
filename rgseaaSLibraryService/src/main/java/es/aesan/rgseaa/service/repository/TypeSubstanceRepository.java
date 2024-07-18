package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeSubstance;

public interface TypeSubstanceRepository
    extends BaseRepository<TypeSubstance, Long>,
    QueryByCriteria<TypeSubstance, GeneralCriteria> {
}
