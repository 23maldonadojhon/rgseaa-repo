package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.model.entity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActivityConverter extends BaseConverter<Activity, ActivityDto> {
}
