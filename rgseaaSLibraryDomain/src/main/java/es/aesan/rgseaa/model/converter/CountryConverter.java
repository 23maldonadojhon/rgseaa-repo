package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.model.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryConverter extends BaseConverter<Country,CountryDto>{

}
