package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.model.entity.Authorization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorizationConverter extends BaseConverter<Authorization, AuthorizationDto> {

}
