package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.RgseaaAuthorizationDto;
import es.aesan.rgseaa.model.entity.RgseaaAuthorization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {
            RgseaaConverter.class,
            AuthorizationConverter.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RgseaaAuthorizationConverter extends BaseConverter<RgseaaAuthorization, RgseaaAuthorizationDto> {
}
