package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.CcaaDto;
import es.aesan.rgseaa.model.entity.Ccaa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CcaaConverter extends BaseConverter<Ccaa, CcaaDto> {
}
