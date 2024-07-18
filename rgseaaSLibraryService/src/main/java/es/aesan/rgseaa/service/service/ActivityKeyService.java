package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.entity.ActivityKey;
import es.aesan.rgseaa.service.repository.ActivityKeyRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityKeyService extends AbstractService<
        ActivityKey,
        Long,
        ActivityKeyRepository,
        ActivityKeyCriteria> {

    ActivityKeyService(ActivityKeyRepository repository) {
        super(repository);
    }
}
