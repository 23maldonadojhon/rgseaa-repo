package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EntitieTypeDto;
import es.aesan.rgseaa.model.entity.EntitieType;
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
public class EntitieTypeConverterImpl implements EntitieTypeConverter {

    @Override
    public EntitieType dtoToEntity(EntitieTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        EntitieType entitieType = new EntitieType();

        entitieType.setState( dto.getState() );
        entitieType.setId( dto.getId() );
        entitieType.setName( dto.getName() );
        entitieType.setDescription( dto.getDescription() );

        return entitieType;
    }

    @Override
    public EntitieTypeDto entityToDto(EntitieType entity) {
        if ( entity == null ) {
            return null;
        }

        EntitieTypeDto entitieTypeDto = new EntitieTypeDto();

        entitieTypeDto.setId( entity.getId() );
        entitieTypeDto.setName( entity.getName() );
        entitieTypeDto.setDescription( entity.getDescription() );
        entitieTypeDto.setState( entity.getState() );

        return entitieTypeDto;
    }

    @Override
    public List<EntitieTypeDto> mapEntityToDtoList(List<EntitieType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EntitieTypeDto> list = new ArrayList<EntitieTypeDto>( entityList.size() );
        for ( EntitieType entitieType : entityList ) {
            list.add( entityToDto( entitieType ) );
        }

        return list;
    }

    @Override
    public List<EntitieType> mapDtoToEntityList(List<EntitieTypeDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EntitieType> list = new ArrayList<EntitieType>( dtoList.size() );
        for ( EntitieTypeDto entitieTypeDto : dtoList ) {
            list.add( dtoToEntity( entitieTypeDto ) );
        }

        return list;
    }
}
