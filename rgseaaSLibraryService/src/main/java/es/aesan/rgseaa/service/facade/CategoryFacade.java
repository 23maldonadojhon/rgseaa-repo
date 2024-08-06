package es.aesan.rgseaa.service.facade;

<<<<<<< HEAD
=======
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;

>>>>>>> 540deec7f3aa9a04632545069d20492c66fee373
import es.aesan.rgseaa.model.converter.CategoryConverter;


import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.dto.CategoryDto;


import es.aesan.rgseaa.model.entity.Category;



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

<<<<<<< HEAD
=======
/*import java.util.ArrayList;
>>>>>>> 540deec7f3aa9a04632545069d20492c66fee373
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;*/

@Component
@RequiredArgsConstructor
public class CategoryFacade extends AbstractFacade<
        CategoryDto,
   CategoryCriteria

        > {

    @Autowired
    private final CategoryService categoryService;

  /*  @Autowired
    private final ActivityKeyService activityKeyService;*/

    @Autowired
    private final ActivityKeyCategoryService activityKeyCategoryService;


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


}
