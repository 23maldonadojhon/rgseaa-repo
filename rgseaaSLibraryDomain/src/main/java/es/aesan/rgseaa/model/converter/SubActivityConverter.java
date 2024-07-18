package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.SubActivityDto;
import es.aesan.rgseaa.model.entity.SubActivity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubActivityConverter
    extends BaseConverter<SubActivity, SubActivityDto> {
}
