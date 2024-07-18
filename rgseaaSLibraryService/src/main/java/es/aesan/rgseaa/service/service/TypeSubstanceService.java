package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeSubstance;
import es.aesan.rgseaa.service.repository.TypeSubstanceRepository;

public class TypeSubstanceService extends AbstractService<
        TypeSubstance,
        Long,
        TypeSubstanceRepository,
        GeneralCriteria> {


    TypeSubstanceService(TypeSubstanceRepository repository) {
        super(repository);
    }
}
