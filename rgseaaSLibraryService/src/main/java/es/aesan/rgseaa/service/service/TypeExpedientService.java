package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeExpedient;
import es.aesan.rgseaa.service.repository.TypeExpedientRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeExpedientService
        extends AbstractService<
        TypeExpedient,
        Long,
        TypeExpedientRepository,
        GeneralCriteria> {


    TypeExpedientService(TypeExpedientRepository repository) {
        super(repository);
    }

}
