package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.model.entity.Authorization;
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
public class AuthorizationConverterImpl implements AuthorizationConverter {

    @Override
    public Authorization dtoToEntity(AuthorizationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Authorization authorization = new Authorization();

        authorization.setState( dto.getState() );
        authorization.setId( dto.getId() );
        authorization.setName( dto.getName() );

        return authorization;
    }

    @Override
    public AuthorizationDto entityToDto(Authorization entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorizationDto authorizationDto = new AuthorizationDto();

        authorizationDto.setId( entity.getId() );
        authorizationDto.setName( entity.getName() );
        authorizationDto.setState( entity.getState() );

        return authorizationDto;
    }

    @Override
    public List<AuthorizationDto> mapEntityToDtoList(List<Authorization> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AuthorizationDto> list = new ArrayList<AuthorizationDto>( entityList.size() );
        for ( Authorization authorization : entityList ) {
            list.add( entityToDto( authorization ) );
        }

        return list;
    }

    @Override
    public List<Authorization> mapDtoToEntityList(List<AuthorizationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Authorization> list = new ArrayList<Authorization>( dtoList.size() );
        for ( AuthorizationDto authorizationDto : dtoList ) {
            list.add( dtoToEntity( authorizationDto ) );
        }

        return list;
    }
}
