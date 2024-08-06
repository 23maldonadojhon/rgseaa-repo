package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.entity.Rgseaa;
import es.aesan.rgseaa.service.repository.RgseaaRepository;
import org.springframework.stereotype.Service;

@Service
public class RgseaaService extends AbstractService<
        Rgseaa,
        Long,
        RgseaaRepository,
        RgseaaCriteria
        > {


    RgseaaService(RgseaaRepository repository) {
        super(repository);
    }
}
