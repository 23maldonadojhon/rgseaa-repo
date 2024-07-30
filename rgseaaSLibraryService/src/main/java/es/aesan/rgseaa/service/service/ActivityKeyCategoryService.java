package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.ActivityKeyCategoryCriteria;
import es.aesan.rgseaa.model.entity.ActivityKeyCategory;
import es.aesan.rgseaa.service.repository.ActivityKeyCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityKeyCategoryService extends AbstractService<
        ActivityKeyCategory,
        Long,
        ActivityKeyCategoryRepository,
        ActivityKeyCategoryCriteria
        >{

    ActivityKeyCategoryService(ActivityKeyCategoryRepository repository) {
        super(repository);
    }

}
