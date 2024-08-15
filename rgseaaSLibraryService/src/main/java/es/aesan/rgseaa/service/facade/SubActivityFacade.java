package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.SubActivityConverter;
import es.aesan.rgseaa.model.criteria.ActivityKeyCategoryCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCategorySubActivityCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.criteria.SubActivityCriteria;
import es.aesan.rgseaa.model.dto.SubActivityDto;
import es.aesan.rgseaa.model.entity.ActivityKey;
import es.aesan.rgseaa.model.entity.ActivityKeyCategory;
import es.aesan.rgseaa.model.entity.ActivityKeyCategorySubActivity;
import es.aesan.rgseaa.model.entity.SubActivity;
import es.aesan.rgseaa.service.service.ActivityKeyCategoryService;
import es.aesan.rgseaa.service.service.ActivityKeyCategorySubActivityService;
import es.aesan.rgseaa.service.service.ActivityKeyService;
import es.aesan.rgseaa.service.service.SubActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubActivityFacade extends AbstractFacade<
        SubActivityDto,
        SubActivityCriteria>  {


    private final ActivityKeyService activityKeyService;

    private final SubActivityService subActivityService;

    private final ActivityKeyCategoryService activityKeyCategoryService;

    private final ActivityKeyCategorySubActivityService activityKeyCategorySubActivityService;


    private final SubActivityConverter converter;

    @Override
    public void add(SubActivityDto dto) {
        SubActivity subActivity = converter.dtoToEntity(dto);
        subActivityService.add(subActivity);
    }

    @Override
    public Page<SubActivityDto> page(SubActivityCriteria criteria) {
        Page<SubActivity> list = subActivityService.page(criteria);
        Page<SubActivityDto> dtoList = converter.mapEntityToDtoPage(list);
        return dtoList;
    }

    @Override
    public List<SubActivityDto> list(SubActivityCriteria criteria) {

        ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
        activityKeyCriteria.setKeyId(criteria.getKeyId());
        activityKeyCriteria.setActivityId(criteria.getActivityId());

        ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

        ActivityKeyCategoryCriteria activityKeyCategoryCriteria = new ActivityKeyCategoryCriteria();
        activityKeyCategoryCriteria.setActivityKeyId(activityKey.getId());
        activityKeyCategoryCriteria.setCategoryId(criteria.getCategoryId());

        ActivityKeyCategory activityKeyCategory = activityKeyCategoryService.find(activityKeyCategoryCriteria);

        ActivityKeyCategorySubActivityCriteria activityKeyCategorySubActivityCriteria = new ActivityKeyCategorySubActivityCriteria();
        activityKeyCategorySubActivityCriteria.setActivityKeyCategoryId(activityKeyCategory.getId());
        Collection<ActivityKeyCategorySubActivity>  resultList = activityKeyCategorySubActivityService.list(activityKeyCategorySubActivityCriteria);

        List<SubActivity> list = resultList.stream().map(ActivityKeyCategorySubActivity::getSubActivity).collect(Collectors.toList());
        List<SubActivityDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));

        return dtoList;
    }
}
