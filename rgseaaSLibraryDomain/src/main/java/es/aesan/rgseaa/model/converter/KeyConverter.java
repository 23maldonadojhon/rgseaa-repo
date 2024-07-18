package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.entity.Key;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KeyConverter extends BaseConverter<Key,KeyDto> {

}
