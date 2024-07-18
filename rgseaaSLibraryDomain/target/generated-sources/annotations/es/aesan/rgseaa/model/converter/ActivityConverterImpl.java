package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.model.entity.Activity;
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
public class ActivityConverterImpl implements ActivityConverter {

    @Override
    public Activity dtoToEntity(ActivityDto dto) {
        if ( dto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setId( dto.getId() );
        activity.setCode( dto.getCode() );
        activity.setName( dto.getName() );
        activity.setIsPublic( dto.getIsPublic() );

        return activity;
    }

    @Override
    public ActivityDto entityToDto(Activity entity) {
        if ( entity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        activityDto.setId( entity.getId() );
        activityDto.setCode( entity.getCode() );
        activityDto.setName( entity.getName() );
        activityDto.setIsPublic( entity.getIsPublic() );

        return activityDto;
    }

    @Override
    public List<ActivityDto> mapEntityToDtoList(List<Activity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ActivityDto> list = new ArrayList<ActivityDto>( entityList.size() );
        for ( Activity activity : entityList ) {
            list.add( entityToDto( activity ) );
        }

        return list;
    }

    @Override
    public List<Activity> mapDtoToEntityList(List<ActivityDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( dtoList.size() );
        for ( ActivityDto activityDto : dtoList ) {
            list.add( dtoToEntity( activityDto ) );
        }

        return list;
    }
}
