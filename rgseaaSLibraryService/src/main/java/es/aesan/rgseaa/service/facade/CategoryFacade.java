package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.CategoryConverter;
import es.aesan.rgseaa.model.criteria.ActivityKeyCategoryCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.model.entity.ActivityKey;
import es.aesan.rgseaa.model.entity.ActivityKeyCategory;
import es.aesan.rgseaa.model.entity.Category;
import es.aesan.rgseaa.service.service.ActivityKeyCategoryService;
import es.aesan.rgseaa.service.service.ActivityKeyService;
import es.aesan.rgseaa.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryFacade extends AbstractFacade<
        CategoryDto,
        CategoryCriteria> {

    @Autowired
    private final CategoryService categoryService;

    @Autowired
    private final ActivityKeyService activityKeyService;

    @Autowired
    private final ActivityKeyCategoryService activityKeyCategoryService;


    @Autowired
    private final CategoryConverter categoryConverter;



    public List<CategoryDto> list(CategoryCriteria categoryCriteria) {

        ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
        activityKeyCriteria.setKeyId(categoryCriteria.getKeyId());
        activityKeyCriteria.setActivityId(categoryCriteria.getActivityId());

        ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

        ActivityKeyCategoryCriteria activityKeyCategoryCriteria = new ActivityKeyCategoryCriteria();
        activityKeyCategoryCriteria.setActivityKeyId(activityKey.getId());

        Collection<ActivityKeyCategory> activityKeyCategoryList = activityKeyCategoryService.list(activityKeyCategoryCriteria);
        List<Category> categoryList = activityKeyCategoryList.stream().map(ActivityKeyCategory::getCategory).collect(Collectors.toList());
        List<CategoryDto> dtoList = categoryConverter.mapEntityToDtoList(categoryList);

        return dtoList;
    }

}
