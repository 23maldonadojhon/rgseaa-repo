package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Establishment;
import es.aesan.rgseaa.service.repository.EstablishmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService extends AbstractService <
        Establishment,
        Long,
        EstablishmentRepository,
        GeneralCriteria
        >{

    EstablishmentService(EstablishmentRepository repository) {
        super(repository);
    }
}
