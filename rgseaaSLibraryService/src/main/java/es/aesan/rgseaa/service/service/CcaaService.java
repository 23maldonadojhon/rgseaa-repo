package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Ccaa;
import es.aesan.rgseaa.service.repository.CcaaRepository;
import org.springframework.stereotype.Service;

@Service
public class CcaaService extends AbstractService<
        Ccaa,
        Long,
        CcaaRepository,
        GeneralCriteria> {

    CcaaService(CcaaRepository repository) {
        super(repository);
    }
}
