package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.LocationDto;
import es.aesan.rgseaa.model.entity.Location;
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
public class LocationConverterImpl implements LocationConverter {

    @Override
    public Location dtoToEntity(LocationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Location location = new Location();

        location.setId( dto.getId() );
        location.setName( dto.getName() );
        location.setEnrollmentProvince( dto.getEnrollmentProvince() );
        location.setDescriptionPadre( dto.getDescriptionPadre() );
        location.setCombo( dto.getCombo() );
        location.setCodeIne( dto.getCodeIne() );

        return location;
    }

    @Override
    public LocationDto entityToDto(Location entity) {
        if ( entity == null ) {
            return null;
        }

        LocationDto locationDto = new LocationDto();

        locationDto.setId( entity.getId() );
        locationDto.setName( entity.getName() );
        locationDto.setEnrollmentProvince( entity.getEnrollmentProvince() );
        locationDto.setDescriptionPadre( entity.getDescriptionPadre() );
        locationDto.setCombo( entity.getCombo() );
        locationDto.setCodeIne( entity.getCodeIne() );

        return locationDto;
    }

    @Override
    public List<LocationDto> mapEntityToDtoList(List<Location> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LocationDto> list = new ArrayList<LocationDto>( entityList.size() );
        for ( Location location : entityList ) {
            list.add( entityToDto( location ) );
        }

        return list;
    }

    @Override
    public List<Location> mapDtoToEntityList(List<LocationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Location> list = new ArrayList<Location>( dtoList.size() );
        for ( LocationDto locationDto : dtoList ) {
            list.add( dtoToEntity( locationDto ) );
        }

        return list;
    }
}
