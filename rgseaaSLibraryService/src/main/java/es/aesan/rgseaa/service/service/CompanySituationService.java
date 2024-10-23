package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.CompanySituation;
import es.aesan.rgseaa.service.repository.CompanySituationRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanySituationService  extends AbstractService<
        CompanySituation,
        Long,
        CompanySituationRepository,
        GeneralCriteria
        > {
    CompanySituationService(CompanySituationRepository repository) {
        super(repository);
    }
}
