package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.FormPresentationDto;
import es.aesan.rgseaa.model.entity.FormPresentation;
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
public class FormPresentationConverterImpl implements FormPresentationConverter {

    @Override
    public FormPresentation dtoToEntity(FormPresentationDto dto) {
        if ( dto == null ) {
            return null;
        }

        FormPresentation formPresentation = new FormPresentation();

        formPresentation.setId( dto.getId() );
        formPresentation.setName( dto.getName() );
        formPresentation.setType( dto.getType() );
        formPresentation.setDateRegister( dto.getDateRegister() );
        formPresentation.setDateUnregister( dto.getDateUnregister() );

        return formPresentation;
    }

    @Override
    public FormPresentationDto entityToDto(FormPresentation entity) {
        if ( entity == null ) {
            return null;
        }

        FormPresentationDto formPresentationDto = new FormPresentationDto();

        formPresentationDto.setId( entity.getId() );
        formPresentationDto.setName( entity.getName() );
        formPresentationDto.setType( entity.getType() );
        formPresentationDto.setDateRegister( entity.getDateRegister() );
        formPresentationDto.setDateUnregister( entity.getDateUnregister() );

        return formPresentationDto;
    }

    @Override
    public List<FormPresentationDto> mapEntityToDtoList(List<FormPresentation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FormPresentationDto> list = new ArrayList<FormPresentationDto>( entityList.size() );
        for ( FormPresentation formPresentation : entityList ) {
            list.add( entityToDto( formPresentation ) );
        }

        return list;
    }

    @Override
    public List<FormPresentation> mapDtoToEntityList(List<FormPresentationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FormPresentation> list = new ArrayList<FormPresentation>( dtoList.size() );
        for ( FormPresentationDto formPresentationDto : dtoList ) {
            list.add( dtoToEntity( formPresentationDto ) );
        }

        return list;
    }
}
