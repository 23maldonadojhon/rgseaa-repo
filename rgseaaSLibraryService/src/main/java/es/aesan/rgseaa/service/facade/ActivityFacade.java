package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.ActivityConverter;
import es.aesan.rgseaa.model.criteria.ActivityCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.model.entity.Activity;
import es.aesan.rgseaa.model.entity.ActivityKey;
import es.aesan.rgseaa.service.service.ActivityKeyService;
import es.aesan.rgseaa.service.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ActivityFacade extends AbstractFacade<
        ActivityDto,
        ActivityCriteria
        > {

    @Autowired
    private final ActivityService activityService;

    @Autowired
    private final ActivityKeyService activityKeyService;


    @Autowired
    private final ActivityConverter activityConverter;

    private static final Logger logger = LoggerFactory.getLogger(ActivityFacade.class);

    @Override
    public List<ActivityDto> list(ActivityCriteria criteria) {
        logger.info("====  FACADE->  KEY CRITERIA {} ====",criteria);

        ActivityKeyCriteria criteriaKey = new ActivityKeyCriteria();
        criteriaKey.setKeyId(criteria.getKeyId());
        Collection<ActivityKey> activityKeyList = activityKeyService.list(criteriaKey);

        List<Activity> list = activityKeyList.stream().map(ActivityKey::getActivity).collect(Collectors.toList());
        List<ActivityDto> dtoList = activityConverter.mapEntityToDtoList(new ArrayList<>(list));

        return dtoList;
    }
}
