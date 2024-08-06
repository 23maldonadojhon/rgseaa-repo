package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.dto.RgseaaDto;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.model.entity.Rgseaa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RgseaaConverter
    extends BaseConverter<Rgseaa, RgseaaDto> {

    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "keyId", source = "key.id")
    RgseaaDto entityToDto(Rgseaa entity);
}
