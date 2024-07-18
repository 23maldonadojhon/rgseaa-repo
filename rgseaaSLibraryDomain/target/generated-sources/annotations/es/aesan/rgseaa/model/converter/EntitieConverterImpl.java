package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.model.entity.Entitie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T08:06:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class EntitieConverterImpl implements EntitieConverter {

    @Autowired
    private EntitieTypeConverter entitieTypeConverter;

    @Override
    public Entitie dtoToEntity(EntitieDto dto) {
        if ( dto == null ) {
            return null;
        }

        Entitie entitie = new Entitie();

        entitie.setState( dto.getState() );
        entitie.setId( dto.getId() );
        entitie.setName( dto.getName() );
        entitie.setCode( dto.getCode() );
        entitie.setDescription( dto.getDescription() );
        entitie.setPostalCode( dto.getPostalCode() );
        entitie.setAddress( dto.getAddress() );
        entitie.setContactPerson( dto.getContactPerson() );
        entitie.setPhone( dto.getPhone() );
        entitie.setEmail( dto.getEmail() );
        entitie.setRootEntity( dto.isRootEntity() );
        entitie.setEntityType( entitieTypeConverter.dtoToEntity( dto.getEntityType() ) );

        return entitie;
    }

    @Override
    public List<EntitieDto> mapEntityToDtoList(List<Entitie> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EntitieDto> list = new ArrayList<EntitieDto>( entityList.size() );
        for ( Entitie entitie : entityList ) {
            list.add( entityToDto( entitie ) );
        }

        return list;
    }

    @Override
    public List<Entitie> mapDtoToEntityList(List<EntitieDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Entitie> list = new ArrayList<Entitie>( dtoList.size() );
        for ( EntitieDto entitieDto : dtoList ) {
            list.add( dtoToEntity( entitieDto ) );
        }

        return list;
    }

    @Override
    public EntitieDto entityToDto(Entitie entity) {
        if ( entity == null ) {
            return null;
        }

        EntitieDto entitieDto = new EntitieDto();

        entitieDto.setName( entity.getName() );
        entitieDto.setDescription( entity.getDescription() );
        entitieDto.setId( entity.getId() );
        entitieDto.setState( entity.getState() );
        entitieDto.setCode( entity.getCode() );
        entitieDto.setPostalCode( entity.getPostalCode() );
        entitieDto.setAddress( entity.getAddress() );
        entitieDto.setContactPerson( entity.getContactPerson() );
        entitieDto.setPhone( entity.getPhone() );
        entitieDto.setEmail( entity.getEmail() );
        entitieDto.setRootEntity( entity.isRootEntity() );
        entitieDto.setEntityType( entitieTypeConverter.entityToDto( entity.getEntityType() ) );

        return entitieDto;
    }
}
