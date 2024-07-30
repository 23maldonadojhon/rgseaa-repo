package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.service.repository.SituationRepository;
import org.springframework.stereotype.Service;


@Service
public class SituationService
        extends AbstractService<
        Situation,
        Long,
        SituationRepository,
        GeneralCriteria> {

    SituationService(SituationRepository repository){
        super(repository);
    }

}
