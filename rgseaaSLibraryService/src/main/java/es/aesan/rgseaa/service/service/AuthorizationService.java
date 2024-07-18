package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Authorization;
import es.aesan.rgseaa.service.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService
        extends AbstractService<
            Authorization,
            Long,
            AuthorizationRepository,
            GeneralCriteria> {

    AuthorizationService(AuthorizationRepository repository) {
        super(repository);
    }

    public List<Authorization> all(GeneralCriteria criteria){

        logger.info("==== ALL Action ====");
        logger.info("entity :"+criteria.toString());

        List<Authorization> documentList = repository.findAll(criteria);

        return documentList;
    }
}
