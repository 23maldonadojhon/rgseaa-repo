package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.ActivityConverter;
import es.aesan.rgseaa.model.converter.CategoryConverter;
import es.aesan.rgseaa.model.converter.KeyActivityConverter;
import es.aesan.rgseaa.model.converter.KeyConverter;
import es.aesan.rgseaa.model.criteria.ActivityKeyCategoryCriteria;
import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.ActivityKeyCategoryService;
import es.aesan.rgseaa.service.service.ActivityKeyService;
import es.aesan.rgseaa.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CategoryFacade extends AbstractFacade<
        CategoryDto,
        CategoryCriteria> {

    private final CategoryService categoryService;
    private final ActivityKeyService activityKeyService;
    private final ActivityKeyCategoryService activityKeyCategoryService;

    private final CategoryConverter categoryConverter;
    private final KeyConverter keyConverter;
    private final ActivityConverter activityConverter;
    private final KeyActivityConverter keyActivityConverter;




    @Override
    @Transactional
    public void add(CategoryDto dto){

        Category category=categoryConverter.dtoToEntity(dto);
        categoryService.add(category);


        category.getKeyActivity().forEach(item->{

            ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
            activityKeyCriteria.setKeyId(item.getKey().getId());
            activityKeyCriteria.setActivityId(item.getActivity().getId());

            ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

            ActivityKeyCategory  activityKeyCategory = new ActivityKeyCategory();
            activityKeyCategory.setCategory(category);
            activityKeyCategory.setActivityKey(activityKey);

            activityKeyCategoryService.add(activityKeyCategory);
        });


    }

    @Override
    public void update(CategoryDto dto){

        Category category=categoryConverter.dtoToEntity(dto);
        categoryService.update(category);

        ActivityKeyCategoryCriteria activityKeyCategoryCriteria = new ActivityKeyCategoryCriteria();
        activityKeyCategoryCriteria.setCategoryId(category.getId());

        Collection<ActivityKeyCategory> activityKeyCategoryList = activityKeyCategoryService.list(activityKeyCategoryCriteria);

        activityKeyCategoryList.forEach(item->activityKeyCategoryService.delete(item.getId()));

        dto.getKeyActivity().forEach(item->{

            ActivityKeyCriteria activityKeyCriteria = new ActivityKeyCriteria();
            activityKeyCriteria.setKeyId(item.getKey().getId());
            activityKeyCriteria.setActivityId(item.getActivity().getId());

            ActivityKey activityKey = activityKeyService.find(activityKeyCriteria);

            ActivityKeyCategory  activityKeyCategory = new ActivityKeyCategory();
            activityKeyCategory.setCategory(category);
            activityKeyCategory.setActivityKey(activityKey);

            activityKeyCategoryService.add(activityKeyCategory);
        });

    }


    @Override
    public Page<CategoryDto> page(CategoryCriteria criteria){
        Page<Category> categoryPage=categoryService.page(criteria);
        Page<CategoryDto> categoryDtoPage=categoryConverter.mapEntityToDtoPage(categoryPage);
        return  categoryDtoPage;
    }

    @Override
    public CategoryDto get(Long id){

        Category category = categoryService.get(id);
        CategoryDto categoryDto = categoryConverter.entityToDto(category);

        ActivityKeyCategoryCriteria activityKeyCategoryCriteria = new ActivityKeyCategoryCriteria();
        activityKeyCategoryCriteria.setCategoryId(category.getId());

        Collection<ActivityKeyCategory> activityKeyCategory = activityKeyCategoryService.list(activityKeyCategoryCriteria);
        List<ActivityKey> activityKeyList = activityKeyCategory.stream().map(ActivityKeyCategory::getActivityKey).collect(Collectors.toList());

        categoryDto.setKeyActivity(keyActivityConverter.mapEntityToDtoList(activityKeyList));

        return  categoryDto;
    }


   public List<CategoryDto> activityList(CategoryCriteria categoryCriteria) {

        ActivityKeyCriteria criteria = new ActivityKeyCriteria();
        criteria.setActivityId(categoryCriteria.getActivityId());

        Collection<ActivityKey> categoryDtoList = activityKeyService.list(criteria);

        List<Long> activityList = categoryDtoList.stream().map(item->item.getActivity().getId()).collect(Collectors.toList());
        List<Category> categoryList = categoryService.findById(activityList);
        List<CategoryDto> dtoList = categoryConverter.mapEntityToDtoList(categoryList);

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

