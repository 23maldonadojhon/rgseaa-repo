package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.SubActivityDto;
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
public class SubActivityConverterImpl implements SubActivityConverter {

    @Override
    public SubActivity dtoToEntity(SubActivityDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubActivity subActivity = new SubActivity();

        subActivity.setId( dto.getId() );
        subActivity.setName( dto.getName() );

        return subActivity;
    }

    @Override
    public SubActivityDto entityToDto(SubActivity entity) {
        if ( entity == null ) {
            return null;
        }

        SubActivityDto subActivityDto = new SubActivityDto();

        subActivityDto.setId( entity.getId() );
        subActivityDto.setName( entity.getName() );

        return subActivityDto;
    }

    @Override
    public List<SubActivityDto> mapEntityToDtoList(List<SubActivity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SubActivityDto> list = new ArrayList<SubActivityDto>( entityList.size() );
        for ( SubActivity subActivity : entityList ) {
            list.add( entityToDto( subActivity ) );
        }

        return list;
    }

    @Override
    public List<SubActivity> mapDtoToEntityList(List<SubActivityDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SubActivity> list = new ArrayList<SubActivity>( dtoList.size() );
        for ( SubActivityDto subActivityDto : dtoList ) {
            list.add( dtoToEntity( subActivityDto ) );
        }

        return list;
    }
}
