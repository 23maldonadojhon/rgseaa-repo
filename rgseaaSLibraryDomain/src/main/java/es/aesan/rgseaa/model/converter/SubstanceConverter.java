package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.SubstanceDto;
import es.aesan.rgseaa.model.entity.Substance;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubstanceConverter
        extends BaseConverter<
        Substance,
        SubstanceDto> {
}
