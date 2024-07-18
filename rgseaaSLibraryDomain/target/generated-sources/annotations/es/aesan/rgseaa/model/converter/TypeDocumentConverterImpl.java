package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.model.entity.TypeDocument;
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
public class TypeDocumentConverterImpl implements TypeDocumentConverter {

    @Override
    public TypeDocument dtoToEntity(TypeDocumentDto dto) {
        if ( dto == null ) {
            return null;
        }

        TypeDocument typeDocument = new TypeDocument();

        typeDocument.setId( dto.getId() );
        typeDocument.setType( dto.getType() );
        typeDocument.setName( dto.getName() );
        typeDocument.setTypeCompanyProduct( dto.getTypeCompanyProduct() );
        typeDocument.setVisible( dto.getVisible() );
        typeDocument.setNoDelete( dto.getNoDelete() );

        return typeDocument;
    }

    @Override
    public TypeDocumentDto entityToDto(TypeDocument entity) {
        if ( entity == null ) {
            return null;
        }

        TypeDocumentDto typeDocumentDto = new TypeDocumentDto();

        typeDocumentDto.setId( entity.getId() );
        typeDocumentDto.setType( entity.getType() );
        typeDocumentDto.setName( entity.getName() );
        typeDocumentDto.setTypeCompanyProduct( entity.getTypeCompanyProduct() );
        typeDocumentDto.setVisible( entity.getVisible() );
        typeDocumentDto.setNoDelete( entity.getNoDelete() );

        return typeDocumentDto;
    }

    @Override
    public List<TypeDocumentDto> mapEntityToDtoList(List<TypeDocument> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeDocumentDto> list = new ArrayList<TypeDocumentDto>( entityList.size() );
        for ( TypeDocument typeDocument : entityList ) {
            list.add( entityToDto( typeDocument ) );
        }

        return list;
    }

    @Override
    public List<TypeDocument> mapDtoToEntityList(List<TypeDocumentDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TypeDocument> list = new ArrayList<TypeDocument>( dtoList.size() );
        for ( TypeDocumentDto typeDocumentDto : dtoList ) {
            list.add( dtoToEntity( typeDocumentDto ) );
        }

        return list;
    }
}
