package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.DocumentDto;
import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.model.entity.Document;
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
public class DocumentConverterImpl implements DocumentConverter {

    @Override
    public Document dtoToEntity(DocumentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Document document = new Document();

        document.setId( dto.getId() );
        document.setName( dto.getName() );
        document.setTypeDocument( typeDocumentDtoToTypeDocument( dto.getTypeDocument() ) );

        return document;
    }

    @Override
    public DocumentDto entityToDto(Document entity) {
        if ( entity == null ) {
            return null;
        }

        DocumentDto documentDto = new DocumentDto();

        documentDto.setId( entity.getId() );
        documentDto.setName( entity.getName() );
        documentDto.setTypeDocument( typeDocumentToTypeDocumentDto( entity.getTypeDocument() ) );

        return documentDto;
    }

    @Override
    public List<DocumentDto> mapEntityToDtoList(List<Document> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DocumentDto> list = new ArrayList<DocumentDto>( entityList.size() );
        for ( Document document : entityList ) {
            list.add( entityToDto( document ) );
        }

        return list;
    }

    @Override
    public List<Document> mapDtoToEntityList(List<DocumentDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Document> list = new ArrayList<Document>( dtoList.size() );
        for ( DocumentDto documentDto : dtoList ) {
            list.add( dtoToEntity( documentDto ) );
        }

        return list;
    }

    protected TypeDocument typeDocumentDtoToTypeDocument(TypeDocumentDto typeDocumentDto) {
        if ( typeDocumentDto == null ) {
            return null;
        }

        TypeDocument typeDocument = new TypeDocument();

        typeDocument.setId( typeDocumentDto.getId() );
        typeDocument.setType( typeDocumentDto.getType() );
        typeDocument.setName( typeDocumentDto.getName() );
        typeDocument.setTypeCompanyProduct( typeDocumentDto.getTypeCompanyProduct() );
        typeDocument.setVisible( typeDocumentDto.getVisible() );
        typeDocument.setNoDelete( typeDocumentDto.getNoDelete() );

        return typeDocument;
    }

    protected TypeDocumentDto typeDocumentToTypeDocumentDto(TypeDocument typeDocument) {
        if ( typeDocument == null ) {
            return null;
        }

        TypeDocumentDto typeDocumentDto = new TypeDocumentDto();

        typeDocumentDto.setId( typeDocument.getId() );
        typeDocumentDto.setType( typeDocument.getType() );
        typeDocumentDto.setName( typeDocument.getName() );
        typeDocumentDto.setTypeCompanyProduct( typeDocument.getTypeCompanyProduct() );
        typeDocumentDto.setVisible( typeDocument.getVisible() );
        typeDocumentDto.setNoDelete( typeDocument.getNoDelete() );

        return typeDocumentDto;
    }
}
