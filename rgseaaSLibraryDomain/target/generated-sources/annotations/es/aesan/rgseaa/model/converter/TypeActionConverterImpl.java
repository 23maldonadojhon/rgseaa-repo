package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.model.entity.TypeAction;
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
public class TypeActionConverterImpl implements TypeActionConverter {

    @Override
    public TypeAction dtoToEntity(TypeActionDto dto) {
        if ( dto == null ) {
            return null;
        }

        TypeAction typeAction = new TypeAction();

        typeAction.setId( dto.getId() );
        typeAction.setName( dto.getName() );
        typeAction.setNoDelete( dto.getNoDelete() );
        typeAction.setVisibleCcaa( dto.getVisibleCcaa() );

        return typeAction;
    }

    @Override
    public TypeActionDto entityToDto(TypeAction entity) {
        if ( entity == null ) {
            return null;
        }

        TypeActionDto typeActionDto = new TypeActionDto();

        typeActionDto.setId( entity.getId() );
        typeActionDto.setName( entity.getName() );
        typeActionDto.setNoDelete( entity.getNoDelete() );
        typeActionDto.setVisibleCcaa( entity.getVisibleCcaa() );

        return typeActionDto;
    }

    @Override
    public List<TypeActionDto> mapEntityToDtoList(List<TypeAction> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeActionDto> list = new ArrayList<TypeActionDto>( entityList.size() );
        for ( TypeAction typeAction : entityList ) {
            list.add( entityToDto( typeAction ) );
        }

        return list;
    }

    @Override
    public List<TypeAction> mapDtoToEntityList(List<TypeActionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TypeAction> list = new ArrayList<TypeAction>( dtoList.size() );
        for ( TypeActionDto typeActionDto : dtoList ) {
            list.add( dtoToEntity( typeActionDto ) );
        }

        return list;
    }
}
