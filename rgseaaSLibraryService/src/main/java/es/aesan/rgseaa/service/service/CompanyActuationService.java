package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.CompanyActuationCriteria;
import es.aesan.rgseaa.model.entity.Actuation;
import es.aesan.rgseaa.service.repository.CompanyActuationRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyActuationService extends AbstractService<
        Actuation,
        Long,
        CompanyActuationRepository,
        CompanyActuationCriteria
        > {

    CompanyActuationService(CompanyActuationRepository repository) {
        super(repository);
    }

}
