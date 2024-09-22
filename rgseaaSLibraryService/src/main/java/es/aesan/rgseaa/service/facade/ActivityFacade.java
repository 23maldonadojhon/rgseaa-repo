package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.ActivityConverter;
import es.aesan.rgseaa.model.converter.KeyConverter;
import es.aesan.rgseaa.model.criteria.ActivityCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.model.entity.Activity;
import es.aesan.rgseaa.model.entity.ActivityKey;
import es.aesan.rgseaa.model.entity.Category;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.service.service.ActivityKeyService;
import es.aesan.rgseaa.service.service.ActivityService;
import es.aesan.rgseaa.service.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    private final ActivityService activityService;
    private final KeyService keyService;
    private final ActivityKeyService activityKeyService;

    private final ActivityConverter activityConverter;
    private final KeyConverter keyConverter;

    private static final Logger logger = LoggerFactory.getLogger(ActivityFacade.class);


    @Override
    public ActivityDto get(Long id) {

        Activity activity = activityService.get(id);
        ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
        activityKeyCriteria.setActivityId(activity.getId());

        ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

        ActivityDto activityDto = activityConverter.entityToDto(activity);
        activityDto.setKey(keyConverter.entityToDto(activityKey.getKey()));

        return activityDto;
    }

    @Override
    @Transactional
    public void add(ActivityDto dto) {

        logger.info("====  FACADE-> ADD CATEGORY {} ====",dto);

        Activity activity = activityConverter.dtoToEntity(dto);
        activity.setIsPublic(1);
        activityService.add(activity);

        Key key =  keyService.get(dto.getKey().getId());

        ActivityKey activityKey = new ActivityKey();
        activityKey.setKey(key);
        activityKey.setActivity(activity);

        activityKeyService.add(activityKey);

    }


    @Override
    @Transactional
    public void update(ActivityDto dto) {

        logger.info("====  FACADE-> UPDATE CATEGORY {} ====",dto);
        Activity activity = activityConverter.dtoToEntity(dto);
        activity.setIsPublic(1);
        activityService.update(activity);

        Key key =  keyService.get(dto.getKey().getId());

        ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
        activityKeyCriteria.setActivityId(dto.getId());
        ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

        activityKey.setKey(key);

        activityKeyService.update(activityKey);
    }


    @Override
    public List<ActivityDto> list(ActivityCriteria criteria) {
        logger.info("====  FACADE->  LIST CATEGORY {} ====",criteria);

        ActivityKeyCriteria criteriaKey = new ActivityKeyCriteria();
        criteriaKey.setKeyId(criteria.getKeyId());
        Collection<ActivityKey> activityKeyList = activityKeyService.list(criteriaKey);

        List<Activity> list = activityKeyList.stream().map(ActivityKey::getActivity).collect(Collectors.toList());
        List<ActivityDto> dtoList = activityConverter.mapEntityToDtoList(new ArrayList<>(list));

        return dtoList;
    }


    @Override
    public Page<ActivityDto> page(ActivityCriteria criteria) {


        Page<Activity> activityPage = activityService.page(criteria);

        Page<ActivityDto> dtoPage = activityConverter.mapEntityToDtoPage(activityPage);

        dtoPage.stream().forEach(item->{
            ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
            activityKeyCriteria.setActivityId(item.getId());
            ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);
            item.setKey(keyConverter.entityToDto(activityKey.getKey()));
        });

        return dtoPage;
    }
}
