package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.entity.Key;
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
public class KeyConverterImpl implements KeyConverter {

    @Override
    public Key dtoToEntity(KeyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Key key = new Key();

        key.setState( dto.getState() );
        key.setId( dto.getId() );
        key.setName( dto.getName() );
        key.setDateRegister( dto.getDateRegister() );
        key.setDateUnregister( dto.getDateUnregister() );
        key.setAllowProduct( dto.getAllowProduct() );
        key.setIsPublic( dto.getIsPublic() );

        return key;
    }

    @Override
    public KeyDto entityToDto(Key entity) {
        if ( entity == null ) {
            return null;
        }

        KeyDto keyDto = new KeyDto();

        keyDto.setId( entity.getId() );
        keyDto.setName( entity.getName() );
        keyDto.setDateRegister( entity.getDateRegister() );
        keyDto.setDateUnregister( entity.getDateUnregister() );
        keyDto.setAllowProduct( entity.getAllowProduct() );
        keyDto.setIsPublic( entity.getIsPublic() );
        keyDto.setState( entity.getState() );

        return keyDto;
    }

    @Override
    public List<KeyDto> mapEntityToDtoList(List<Key> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<KeyDto> list = new ArrayList<KeyDto>( entityList.size() );
        for ( Key key : entityList ) {
            list.add( entityToDto( key ) );
        }

        return list;
    }

    @Override
    public List<Key> mapDtoToEntityList(List<KeyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Key> list = new ArrayList<Key>( dtoList.size() );
        for ( KeyDto keyDto : dtoList ) {
            list.add( dtoToEntity( keyDto ) );
        }

        return list;
    }
}
