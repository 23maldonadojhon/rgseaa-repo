package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.SituationDto;
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
public class SituationConverterImpl implements SituationConverter {

    @Override
    public Situation dtoToEntity(SituationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Situation situation = new Situation();

        situation.setId( dto.getId() );
        situation.setName( dto.getName() );
        situation.setTypeIndustryProduct( dto.getTypeIndustryProduct() );
        situation.setNewOption( dto.getNewOption() );
        situation.setNoDelete( dto.getNoDelete() );
        situation.setVisibleRgsa( dto.getVisibleRgsa() );
        situation.setVisibleUe( dto.getVisibleUe() );

        return situation;
    }

    @Override
    public SituationDto entityToDto(Situation entity) {
        if ( entity == null ) {
            return null;
        }

        SituationDto situationDto = new SituationDto();

        situationDto.setId( entity.getId() );
        situationDto.setName( entity.getName() );
        situationDto.setTypeIndustryProduct( entity.getTypeIndustryProduct() );
        situationDto.setNewOption( entity.getNewOption() );
        situationDto.setNoDelete( entity.getNoDelete() );
        situationDto.setVisibleRgsa( entity.getVisibleRgsa() );
        situationDto.setVisibleUe( entity.getVisibleUe() );

        return situationDto;
    }

    @Override
    public List<SituationDto> mapEntityToDtoList(List<Situation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SituationDto> list = new ArrayList<SituationDto>( entityList.size() );
        for ( Situation situation : entityList ) {
            list.add( entityToDto( situation ) );
        }

        return list;
    }

    @Override
    public List<Situation> mapDtoToEntityList(List<SituationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Situation> list = new ArrayList<Situation>( dtoList.size() );
        for ( SituationDto situationDto : dtoList ) {
            list.add( dtoToEntity( situationDto ) );
        }

        return list;
    }
}
