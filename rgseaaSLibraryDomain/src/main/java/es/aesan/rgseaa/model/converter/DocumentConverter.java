package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.DocumentDto;
import es.aesan.rgseaa.model.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentConverter extends BaseConverter<Document,DocumentDto> {

}
