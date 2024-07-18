package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.IndustryAuthorizationDto;
import es.aesan.rgseaa.model.entity.IndustryAuthorization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndustryAuthorizationConverter extends BaseConverter<IndustryAuthorization, IndustryAuthorizationDto> {
}
