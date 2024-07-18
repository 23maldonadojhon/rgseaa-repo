package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.UserEntitieDto;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.model.entity.UserEntitie;
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
public class UserEntitieConverterImpl implements UserEntitieConverter {

    @Override
    public UserEntitieDto entityToDto(UserEntitie entity) {
        if ( entity == null ) {
            return null;
        }

        UserEntitieDto userEntitieDto = new UserEntitieDto();

        userEntitieDto.setUser( entityUserId( entity ) );
        userEntitieDto.setEntity( entityEntityId( entity ) );
        userEntitieDto.setEntityCode( entityEntityCode( entity ) );
        userEntitieDto.setEntityName( entityEntityCode( entity ) );
        userEntitieDto.setFirstSurname( entityEntityContactPerson( entity ) );

        return userEntitieDto;
    }

    @Override
    public List<UserEntitieDto> mapEntityToDtoList(List<UserEntitie> entitylist) {
        if ( entitylist == null ) {
            return null;
        }

        List<UserEntitieDto> list = new ArrayList<UserEntitieDto>( entitylist.size() );
        for ( UserEntitie userEntitie : entitylist ) {
            list.add( entityToDto( userEntitie ) );
        }

        return list;
    }

    private Long entityUserId(UserEntitie userEntitie) {
        if ( userEntitie == null ) {
            return null;
        }
        User user = userEntitie.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityEntityId(UserEntitie userEntitie) {
        if ( userEntitie == null ) {
            return null;
        }
        Entitie entity = userEntitie.getEntity();
        if ( entity == null ) {
            return null;
        }
        Long id = entity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityEntityCode(UserEntitie userEntitie) {
        if ( userEntitie == null ) {
            return null;
        }
        Entitie entity = userEntitie.getEntity();
        if ( entity == null ) {
            return null;
        }
        String code = entity.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String entityEntityContactPerson(UserEntitie userEntitie) {
        if ( userEntitie == null ) {
            return null;
        }
        Entitie entity = userEntitie.getEntity();
        if ( entity == null ) {
            return null;
        }
        String contactPerson = entity.getContactPerson();
        if ( contactPerson == null ) {
            return null;
        }
        return contactPerson;
    }
}
