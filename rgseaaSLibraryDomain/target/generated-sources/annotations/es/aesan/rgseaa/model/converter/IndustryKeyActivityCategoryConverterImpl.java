package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.model.dto.IndustryKeyActivityCategoryDto;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.dto.SubActivityDto;
import es.aesan.rgseaa.model.entity.Activity;
import es.aesan.rgseaa.model.entity.Category;
import es.aesan.rgseaa.model.entity.IndustryKeyActivityCategory;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.model.entity.SubActivity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T08:06:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class IndustryKeyActivityCategoryConverterImpl implements IndustryKeyActivityCategoryConverter {

    @Override
    public IndustryKeyActivityCategory dtoToEntity(IndustryKeyActivityCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        IndustryKeyActivityCategory industryKeyActivityCategory = new IndustryKeyActivityCategory();

        industryKeyActivityCategory.setId( dto.getId() );
        industryKeyActivityCategory.setKey( keyDtoToKey( dto.getKey() ) );
        industryKeyActivityCategory.setActivity( activityDtoToActivity( dto.getActivity() ) );
        industryKeyActivityCategory.setCategory( categoryDtoToCategory( dto.getCategory() ) );
        industryKeyActivityCategory.setSubActivity( subActivityDtoToSubActivity( dto.getSubActivity() ) );

        return industryKeyActivityCategory;
    }

    @Override
    public IndustryKeyActivityCategoryDto entityToDto(IndustryKeyActivityCategory entity) {
        if ( entity == null ) {
            return null;
        }

        IndustryKeyActivityCategoryDto industryKeyActivityCategoryDto = new IndustryKeyActivityCategoryDto();

        industryKeyActivityCategoryDto.setId( entity.getId() );
        industryKeyActivityCategoryDto.setKey( keyToKeyDto( entity.getKey() ) );
        industryKeyActivityCategoryDto.setCategory( categoryToCategoryDto( entity.getCategory() ) );
        industryKeyActivityCategoryDto.setActivity( activityToActivityDto( entity.getActivity() ) );
        industryKeyActivityCategoryDto.setSubActivity( subActivityToSubActivityDto( entity.getSubActivity() ) );

        return industryKeyActivityCategoryDto;
    }

    @Override
    public List<IndustryKeyActivityCategoryDto> mapEntityToDtoList(List<IndustryKeyActivityCategory> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<IndustryKeyActivityCategoryDto> list = new ArrayList<IndustryKeyActivityCategoryDto>( entityList.size() );
        for ( IndustryKeyActivityCategory industryKeyActivityCategory : entityList ) {
            list.add( entityToDto( industryKeyActivityCategory ) );
        }

        return list;
    }

    @Override
    public List<IndustryKeyActivityCategory> mapDtoToEntityList(List<IndustryKeyActivityCategoryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<IndustryKeyActivityCategory> list = new ArrayList<IndustryKeyActivityCategory>( dtoList.size() );
        for ( IndustryKeyActivityCategoryDto industryKeyActivityCategoryDto : dtoList ) {
            list.add( dtoToEntity( industryKeyActivityCategoryDto ) );
        }

        return list;
    }

    protected Key keyDtoToKey(KeyDto keyDto) {
        if ( keyDto == null ) {
            return null;
        }

        Key key = new Key();

        key.setState( keyDto.getState() );
        key.setId( keyDto.getId() );
        key.setName( keyDto.getName() );
        key.setDateRegister( keyDto.getDateRegister() );
        key.setDateUnregister( keyDto.getDateUnregister() );
        key.setAllowProduct( keyDto.getAllowProduct() );
        key.setIsPublic( keyDto.getIsPublic() );

        return key;
    }

    protected Activity activityDtoToActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setId( activityDto.getId() );
        activity.setCode( activityDto.getCode() );
        activity.setName( activityDto.getName() );
        activity.setIsPublic( activityDto.getIsPublic() );

        return activity;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );

        return category;
    }

    protected SubActivity subActivityDtoToSubActivity(SubActivityDto subActivityDto) {
        if ( subActivityDto == null ) {
            return null;
        }

        SubActivity subActivity = new SubActivity();

        subActivity.setId( subActivityDto.getId() );
        subActivity.setName( subActivityDto.getName() );

        return subActivity;
    }

    protected KeyDto keyToKeyDto(Key key) {
        if ( key == null ) {
            return null;
        }

        KeyDto keyDto = new KeyDto();

        keyDto.setId( key.getId() );
        keyDto.setName( key.getName() );
        keyDto.setDateRegister( key.getDateRegister() );
        keyDto.setDateUnregister( key.getDateUnregister() );
        keyDto.setAllowProduct( key.getAllowProduct() );
        keyDto.setIsPublic( key.getIsPublic() );
        keyDto.setState( key.getState() );

        return keyDto;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );

        return categoryDto;
    }

    protected ActivityDto activityToActivityDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        activityDto.setId( activity.getId() );
        activityDto.setCode( activity.getCode() );
        activityDto.setName( activity.getName() );
        activityDto.setIsPublic( activity.getIsPublic() );

        return activityDto;
    }

    protected SubActivityDto subActivityToSubActivityDto(SubActivity subActivity) {
        if ( subActivity == null ) {
            return null;
        }

        SubActivityDto subActivityDto = new SubActivityDto();

        subActivityDto.setId( subActivity.getId() );
        subActivityDto.setName( subActivity.getName() );

        return subActivityDto;
    }
}
