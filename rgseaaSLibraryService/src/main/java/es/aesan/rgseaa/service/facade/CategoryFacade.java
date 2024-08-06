package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.CategoryConverter;
import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.model.entity.Category;
import es.aesan.rgseaa.service.service.ActivityKeyCategoryService;
import es.aesan.rgseaa.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;



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
