package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.SituationCriteria;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.service.repository.SituationRepository;
import org.springframework.stereotype.Service;


@Service
public class SituationService
        extends AbstractService<
        Situation,
        Long,
        SituationRepository,
        SituationCriteria> {

    SituationService(SituationRepository repository){
        super(repository);
    }

}
