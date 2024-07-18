package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.EstablishmentDto;
import es.aesan.rgseaa.model.entity.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstablishmentConverter
        extends BaseConverter<Establishment, EstablishmentDto> {


    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "provinceId", source = "province.id")
    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "situationId", source = "situation.id")
    EstablishmentDto entityToDto(Establishment entity);
}
