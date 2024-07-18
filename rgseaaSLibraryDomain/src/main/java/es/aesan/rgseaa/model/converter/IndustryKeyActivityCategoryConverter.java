package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.IndustryKeyActivityCategoryDto;
import es.aesan.rgseaa.model.entity.IndustryKeyActivityCategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndustryKeyActivityCategoryConverter extends BaseConverter<IndustryKeyActivityCategory, IndustryKeyActivityCategoryDto> {
}
