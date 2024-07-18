package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.model.entity.TypeAction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeActionConverter extends BaseConverter<TypeAction,TypeActionDto> {

}
