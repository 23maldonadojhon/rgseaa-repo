package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.CompanyAuthorizationCriteria;
import es.aesan.rgseaa.model.entity.CompanyAuthorization;
import es.aesan.rgseaa.service.repository.CompanyAuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyAuthorizationService  extends AbstractService<
        CompanyAuthorization,
        Long,
        CompanyAuthorizationRepository,
        CompanyAuthorizationCriteria
        > {

    CompanyAuthorizationService(CompanyAuthorizationRepository repository) {
        super(repository);
    }
}
