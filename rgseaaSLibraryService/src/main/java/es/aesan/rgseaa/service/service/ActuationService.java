package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.entity.Actuation;
import es.aesan.rgseaa.service.repository.ActuationRepository;
import org.springframework.stereotype.Service;

@Service
public class ActuationService extends AbstractService<
        Actuation,
        Long,
        ActuationRepository,
        ActuationCriteria
        > {

    ActuationService(ActuationRepository repository) {
        super(repository);
    }

}
