package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.TypeExpedientDto;
import es.aesan.rgseaa.model.entity.TypeExpedient;
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
public class TypeExpedientConverterImpl implements TypeExpedientConverter {

    @Override
    public TypeExpedient dtoToEntity(TypeExpedientDto dto) {
        if ( dto == null ) {
            return null;
        }

        TypeExpedient typeExpedient = new TypeExpedient();

        typeExpedient.setId( (long) dto.getId() );
        typeExpedient.setCode( dto.getCode() );
        typeExpedient.setName( dto.getName() );

        return typeExpedient;
    }

    @Override
    public TypeExpedientDto entityToDto(TypeExpedient entity) {
        if ( entity == null ) {
            return null;
        }

        TypeExpedientDto typeExpedientDto = new TypeExpedientDto();

        if ( entity.getId() != null ) {
            typeExpedientDto.setId( entity.getId().intValue() );
        }
        typeExpedientDto.setName( entity.getName() );
        typeExpedientDto.setCode( entity.getCode() );

        return typeExpedientDto;
    }

    @Override
    public List<TypeExpedientDto> mapEntityToDtoList(List<TypeExpedient> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeExpedientDto> list = new ArrayList<TypeExpedientDto>( entityList.size() );
        for ( TypeExpedient typeExpedient : entityList ) {
            list.add( entityToDto( typeExpedient ) );
        }

        return list;
    }

    @Override
    public List<TypeExpedient> mapDtoToEntityList(List<TypeExpedientDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TypeExpedient> list = new ArrayList<TypeExpedient>( dtoList.size() );
        for ( TypeExpedientDto typeExpedientDto : dtoList ) {
            list.add( dtoToEntity( typeExpedientDto ) );
        }

        return list;
    }
}
