package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ProvinceDto;
import es.aesan.rgseaa.model.entity.Province;
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
public class ProvinceConverterImpl implements ProvinceConverter {

    @Override
    public Province dtoToEntity(ProvinceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Province province = new Province();

        province.setId( dto.getId() );
        province.setName( dto.getName() );
        province.setEnrollment( dto.getEnrollment() );
        province.setPrePostalCode( dto.getPrePostalCode() );
        province.setEnrollmentCCAA( dto.getEnrollmentCCAA() );
        province.setAddress( dto.getAddress() );
        province.setEmail( dto.getEmail() );

        return province;
    }

    @Override
    public ProvinceDto entityToDto(Province entity) {
        if ( entity == null ) {
            return null;
        }

        ProvinceDto provinceDto = new ProvinceDto();

        provinceDto.setId( entity.getId() );
        provinceDto.setName( entity.getName() );
        provinceDto.setEnrollment( entity.getEnrollment() );
        provinceDto.setPrePostalCode( entity.getPrePostalCode() );
        provinceDto.setEnrollmentCCAA( entity.getEnrollmentCCAA() );
        provinceDto.setAddress( entity.getAddress() );
        provinceDto.setEmail( entity.getEmail() );

        return provinceDto;
    }

    @Override
    public List<ProvinceDto> mapEntityToDtoList(List<Province> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProvinceDto> list = new ArrayList<ProvinceDto>( entityList.size() );
        for ( Province province : entityList ) {
            list.add( entityToDto( province ) );
        }

        return list;
    }

    @Override
    public List<Province> mapDtoToEntityList(List<ProvinceDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Province> list = new ArrayList<Province>( dtoList.size() );
        for ( ProvinceDto provinceDto : dtoList ) {
            list.add( dtoToEntity( provinceDto ) );
        }

        return list;
    }
}
