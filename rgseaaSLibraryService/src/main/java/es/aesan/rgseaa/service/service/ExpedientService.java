package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.ExpedientCriteria;
import es.aesan.rgseaa.model.entity.Company;
import es.aesan.rgseaa.service.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpedientService extends AbstractService<
        Company,
        Long,
        CompanyRepository,
        ExpedientCriteria
        > {

    ExpedientService(CompanyRepository repository) {
        super(repository);
    }

}
