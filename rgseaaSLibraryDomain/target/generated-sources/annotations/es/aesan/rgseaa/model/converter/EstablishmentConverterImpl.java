package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EstablishmentDto;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.model.entity.Establishment;
import es.aesan.rgseaa.model.entity.Location;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.model.entity.Situation;
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
public class EstablishmentConverterImpl implements EstablishmentConverter {

    @Override
    public Establishment dtoToEntity(EstablishmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Establishment establishment = new Establishment();

        establishment.setId( dto.getId() );
        establishment.setAddress( dto.getAddress() );
        establishment.setPostalCode( dto.getPostalCode() );

        return establishment;
    }

    @Override
    public List<EstablishmentDto> mapEntityToDtoList(List<Establishment> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EstablishmentDto> list = new ArrayList<EstablishmentDto>( entityList.size() );
        for ( Establishment establishment : entityList ) {
            list.add( entityToDto( establishment ) );
        }

        return list;
    }

    @Override
    public List<Establishment> mapDtoToEntityList(List<EstablishmentDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Establishment> list = new ArrayList<Establishment>( dtoList.size() );
        for ( EstablishmentDto establishmentDto : dtoList ) {
            list.add( dtoToEntity( establishmentDto ) );
        }

        return list;
    }

    @Override
    public EstablishmentDto entityToDto(Establishment entity) {
        if ( entity == null ) {
            return null;
        }

        EstablishmentDto establishmentDto = new EstablishmentDto();

        establishmentDto.setCountryId( entityCountryId( entity ) );
        establishmentDto.setProvinceId( entityProvinceId( entity ) );
        establishmentDto.setLocationId( entityLocationId( entity ) );
        establishmentDto.setSituationId( entitySituationId( entity ) );
        establishmentDto.setId( entity.getId() );
        establishmentDto.setAddress( entity.getAddress() );
        establishmentDto.setPostalCode( entity.getPostalCode() );

        return establishmentDto;
    }

    private Long entityCountryId(Establishment establishment) {
        if ( establishment == null ) {
            return null;
        }
        Country country = establishment.getCountry();
        if ( country == null ) {
            return null;
        }
        Long id = country.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityProvinceId(Establishment establishment) {
        if ( establishment == null ) {
            return null;
        }
        Province province = establishment.getProvince();
        if ( province == null ) {
            return null;
        }
        Long id = province.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityLocationId(Establishment establishment) {
        if ( establishment == null ) {
            return null;
        }
        Location location = establishment.getLocation();
        if ( location == null ) {
            return null;
        }
        Long id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entitySituationId(Establishment establishment) {
        if ( establishment == null ) {
            return null;
        }
        Situation situation = establishment.getSituation();
        if ( situation == null ) {
            return null;
        }
        Long id = situation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
