package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Substance;
import es.aesan.rgseaa.service.repository.SubstanceRepository;
import org.springframework.stereotype.Service;

@Service
public class SubstanceService extends AbstractService<
        Substance,
        Long,
        SubstanceRepository,
        GeneralCriteria> {

    SubstanceService(SubstanceRepository repository) {
        super(repository);
    }
}
