package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ProvinceDto;
import es.aesan.rgseaa.model.entity.Province;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProvinceConverter extends BaseConverter<Province, ProvinceDto>{
}
