package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.CompanyDto;
import es.aesan.rgseaa.model.dto.CompanyFindDto;
import es.aesan.rgseaa.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyConverter
        extends BaseConverter<Company, CompanyDto> {

    @Mapping(target = "id", source = "id")
    @Mapping(target  = "name", source = "name")
    @Mapping(target = "situation", source = "situation.name")
    CompanyFindDto dtoToEntityFind(Company company);

    @Override
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "provinceId", source = "province.id")
    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "situationId", source = "situation.id")
    @Mapping(target = "ccaaId", source = "ccaa.id")
    CompanyDto entityToDto(Company entity);

    List<CompanyFindDto> dtoToEntityFindList(List<Company> company);


    @Named("integerToString")
    default String integerToString(Integer number) {
        return number != null ? number.toString() : null;
    }

}
