package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActuationDto;
import es.aesan.rgseaa.model.entity.Actuation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {TypeActuationConverter.class}
)
public interface ActuationConverter extends BaseConverter<Actuation, ActuationDto> {

 }
