package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EntitieTypeDto;
import es.aesan.rgseaa.model.entity.EntitieType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntitieTypeConverter extends BaseConverter<EntitieType,EntitieTypeDto>{

}
