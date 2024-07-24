package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.model.entity.TypeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeDocumentConverter
        extends BaseConverter
        <TypeDocument,TypeDocumentDto> {

}
