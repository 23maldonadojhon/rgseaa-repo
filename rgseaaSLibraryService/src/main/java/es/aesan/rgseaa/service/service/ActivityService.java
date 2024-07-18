package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.ActivityCriteria;
import es.aesan.rgseaa.model.entity.Activity;
import es.aesan.rgseaa.service.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService extends AbstractService<
        Activity,
        Long,
        ActivityRepository,
        ActivityCriteria> {


    ActivityService(ActivityRepository repository) {
        super(repository);
    }


    public List<Activity> findByActivity(List<String> list){
        logger.info("==== findByActivity ");

        List<Activity> resultList = repository.findByActivity(list);

        return resultList;
    }



}
