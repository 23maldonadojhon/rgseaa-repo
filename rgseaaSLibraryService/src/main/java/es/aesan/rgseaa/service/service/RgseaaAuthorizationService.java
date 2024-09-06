package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.RgseaaAuthorizationCriteria;
import es.aesan.rgseaa.model.entity.RgseaaAuthorization;
import es.aesan.rgseaa.service.repository.RgseaaAuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class RgseaaAuthorizationService extends AbstractService<
        RgseaaAuthorization,
        Long,
        RgseaaAuthorizationRepository,
        RgseaaAuthorizationCriteria
        > {

    RgseaaAuthorizationService(RgseaaAuthorizationRepository repository) {
        super(repository);
    }
}
