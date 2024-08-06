package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.FormPresentationDto;
import es.aesan.rgseaa.model.entity.FormPresentation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FormPresentationConverter extends BaseConverter<
        FormPresentation,
        FormPresentationDto> {

}
