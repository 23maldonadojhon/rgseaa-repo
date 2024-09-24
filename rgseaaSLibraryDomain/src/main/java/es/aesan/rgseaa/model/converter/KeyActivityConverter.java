package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.KeyActivityDto;
import es.aesan.rgseaa.model.entity.ActivityKey;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {KeyConverter.class,ActivityConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeyActivityConverter extends BaseConverter<ActivityKey, KeyActivityDto> {
}
