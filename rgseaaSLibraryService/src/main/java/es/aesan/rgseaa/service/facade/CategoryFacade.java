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
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CategoryFacade extends AbstractFacade<
        CategoryDto,
   CategoryCriteria

        > {

    @Autowired
    private final CategoryService categoryService;

    @Autowired
    private final ActivityKeyCategoryService activityKeyCategoryService;
    @Autowired
    private final ActivityKeyService activityKeyService;

    @Autowired
    private final CategoryConverter categoryConverter;

    @Override
    public void add(CategoryDto dto) {
        Category category = categoryConverter.dtoToEntity(dto);
        categoryService.add(category);
    }

    @Override
    public Page<CategoryDto> page(CategoryCriteria criteria) {
        Page<Category> categoryPage = categoryService.page(criteria);
        Page<CategoryDto>  dtoList = categoryConverter.mapEntityToDtoPage(categoryPage);
        return dtoList;
    }

    @Override
    public List<CategoryDto> list(CategoryCriteria criteria) {

        Collection<Category> categoryCollection =  categoryService.list(criteria);
        List<CategoryDto> dtoList = categoryConverter.mapEntityToDtoList(new ArrayList<>(categoryCollection));
        return dtoList;
    }

    public List<CategoryDto> listActivity(CategoryCriteria categoryCriteria) {

        List<Category> categoryList = new ArrayList<>();

        ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
        activityKeyCriteria.setKeyId(categoryCriteria.getKeyId());
        activityKeyCriteria.setActivityId(categoryCriteria.getActivityId());

        ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);


        ActivityKeyCategoryCriteria activityKeyCategoryCriteria = new ActivityKeyCategoryCriteria();
        activityKeyCategoryCriteria.setActivityKeyId(activityKey.getId());

        Collection<ActivityKeyCategory> activityKeyCategory = activityKeyCategoryService.list(activityKeyCategoryCriteria);

        activityKeyCategory.forEach(item ->categoryList.add(item.getCategory()));

        List<CategoryDto> categoryDtoList = categoryConverter.mapEntityToDtoList(categoryList);

        return categoryDtoList;
    }
}
