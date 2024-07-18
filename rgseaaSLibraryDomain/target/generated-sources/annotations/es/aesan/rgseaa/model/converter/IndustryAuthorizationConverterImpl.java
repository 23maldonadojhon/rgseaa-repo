package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.IndustryAuthorizationDto;
import es.aesan.rgseaa.model.entity.IndustryAuthorization;
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
public class IndustryAuthorizationConverterImpl implements IndustryAuthorizationConverter {

    @Override
    public IndustryAuthorization dtoToEntity(IndustryAuthorizationDto dto) {
        if ( dto == null ) {
            return null;
        }

        IndustryAuthorization industryAuthorization = new IndustryAuthorization();

        return industryAuthorization;
    }

    @Override
    public IndustryAuthorizationDto entityToDto(IndustryAuthorization entity) {
        if ( entity == null ) {
            return null;
        }

        IndustryAuthorizationDto industryAuthorizationDto = new IndustryAuthorizationDto();

        return industryAuthorizationDto;
    }

    @Override
    public List<IndustryAuthorizationDto> mapEntityToDtoList(List<IndustryAuthorization> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<IndustryAuthorizationDto> list = new ArrayList<IndustryAuthorizationDto>( entityList.size() );
        for ( IndustryAuthorization industryAuthorization : entityList ) {
            list.add( entityToDto( industryAuthorization ) );
        }

        return list;
    }

    @Override
    public List<IndustryAuthorization> mapDtoToEntityList(List<IndustryAuthorizationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<IndustryAuthorization> list = new ArrayList<IndustryAuthorization>( dtoList.size() );
        for ( IndustryAuthorizationDto industryAuthorizationDto : dtoList ) {
            list.add( dtoToEntity( industryAuthorizationDto ) );
        }

        return list;
    }
}
