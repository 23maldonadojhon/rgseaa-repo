package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.model.entity.Entitie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntitieConverter extends BaseConverter<Entitie, EntitieDto> {
}
