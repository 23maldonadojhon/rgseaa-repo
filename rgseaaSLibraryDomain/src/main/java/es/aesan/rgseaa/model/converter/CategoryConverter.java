package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {KeyActivityConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter extends BaseConverter<Category,CategoryDto> {
}
