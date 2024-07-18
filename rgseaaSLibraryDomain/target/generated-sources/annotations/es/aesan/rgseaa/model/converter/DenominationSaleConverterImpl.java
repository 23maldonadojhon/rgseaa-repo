package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.DenominationSaleDto;
import es.aesan.rgseaa.model.entity.DenominationSale;
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
public class DenominationSaleConverterImpl implements DenominationSaleConverter {

    @Override
    public DenominationSale dtoToEntity(DenominationSaleDto dto) {
        if ( dto == null ) {
            return null;
        }

        DenominationSale denominationSale = new DenominationSale();

        denominationSale.setState( dto.getState() );
        denominationSale.setId( dto.getId() );
        denominationSale.setName( dto.getName() );
        denominationSale.setFileType( dto.getFileType() );
        denominationSale.setIsPublic( dto.getIsPublic() );
        denominationSale.setDateRegister( dto.getDateRegister() );
        denominationSale.setDateUnregister( dto.getDateUnregister() );
        denominationSale.setActive( dto.getActive() );

        return denominationSale;
    }

    @Override
    public DenominationSaleDto entityToDto(DenominationSale entity) {
        if ( entity == null ) {
            return null;
        }

        DenominationSaleDto denominationSaleDto = new DenominationSaleDto();

        denominationSaleDto.setId( entity.getId() );
        denominationSaleDto.setName( entity.getName() );
        denominationSaleDto.setFileType( entity.getFileType() );
        denominationSaleDto.setIsPublic( entity.getIsPublic() );
        denominationSaleDto.setDateRegister( entity.getDateRegister() );
        denominationSaleDto.setDateUnregister( entity.getDateUnregister() );
        denominationSaleDto.setActive( entity.getActive() );
        denominationSaleDto.setState( entity.getState() );

        return denominationSaleDto;
    }

    @Override
    public List<DenominationSaleDto> mapEntityToDtoList(List<DenominationSale> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DenominationSaleDto> list = new ArrayList<DenominationSaleDto>( entityList.size() );
        for ( DenominationSale denominationSale : entityList ) {
            list.add( entityToDto( denominationSale ) );
        }

        return list;
    }

    @Override
    public List<DenominationSale> mapDtoToEntityList(List<DenominationSaleDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DenominationSale> list = new ArrayList<DenominationSale>( dtoList.size() );
        for ( DenominationSaleDto denominationSaleDto : dtoList ) {
            list.add( dtoToEntity( denominationSaleDto ) );
        }

        return list;
    }
}
