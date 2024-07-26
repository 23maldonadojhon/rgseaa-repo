package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.TypeActuationDto;

import es.aesan.rgseaa.model.entity.TypeActuation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeActuationConverter
        extends BaseConverter<
        TypeActuation,
        TypeActuationDto> {
}
