package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.LocationDto;
import es.aesan.rgseaa.model.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {ProductConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationConverter extends BaseConverter<Location, LocationDto> {

}
