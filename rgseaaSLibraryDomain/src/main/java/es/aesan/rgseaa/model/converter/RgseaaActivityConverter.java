package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.RgseaaActivityDto;
import es.aesan.rgseaa.model.entity.RgseaaActivity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RgseaaActivityConverter extends BaseConverter<RgseaaActivity, RgseaaActivityDto> {
}
