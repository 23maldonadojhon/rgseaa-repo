package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.TypeExpedientDto;
import es.aesan.rgseaa.model.entity.TypeExpedient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeExpedientConverter
        extends BaseConverter<
        TypeExpedient,
        TypeExpedientDto> {
}
