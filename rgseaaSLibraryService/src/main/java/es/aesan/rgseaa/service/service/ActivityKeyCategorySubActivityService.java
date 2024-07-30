package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.ActivityKeyCategorySubActivityCriteria;
import es.aesan.rgseaa.model.entity.ActivityKeyCategorySubActivity;
import es.aesan.rgseaa.service.repository.ActivityKeyCategorySubActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityKeyCategorySubActivityService extends AbstractService<
        ActivityKeyCategorySubActivity,
        Long,
        ActivityKeyCategorySubActivityRepository,
        ActivityKeyCategorySubActivityCriteria> {

    ActivityKeyCategorySubActivityService(ActivityKeyCategorySubActivityRepository repository) {
        super(repository);
    }

}
