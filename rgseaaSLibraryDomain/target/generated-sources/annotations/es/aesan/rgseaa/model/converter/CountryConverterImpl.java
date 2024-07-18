package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.model.entity.Country;
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
public class CountryConverterImpl implements CountryConverter {

    @Override
    public Country dtoToEntity(CountryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( dto.getId() );
        country.setName( dto.getName() );
        country.setEnrollment( dto.getEnrollment() );
        country.setNoDelete( dto.getNoDelete() );

        return country;
    }

    @Override
    public CountryDto entityToDto(Country entity) {
        if ( entity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( entity.getId() );
        countryDto.setName( entity.getName() );
        countryDto.setEnrollment( entity.getEnrollment() );
        countryDto.setNoDelete( entity.getNoDelete() );

        return countryDto;
    }

    @Override
    public List<CountryDto> mapEntityToDtoList(List<Country> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( entityList.size() );
        for ( Country country : entityList ) {
            list.add( entityToDto( country ) );
        }

        return list;
    }

    @Override
    public List<Country> mapDtoToEntityList(List<CountryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Country> list = new ArrayList<Country>( dtoList.size() );
        for ( CountryDto countryDto : dtoList ) {
            list.add( dtoToEntity( countryDto ) );
        }

        return list;
    }
}
