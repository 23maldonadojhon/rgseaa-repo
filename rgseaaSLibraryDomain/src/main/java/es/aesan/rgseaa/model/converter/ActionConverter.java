package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.ActionDto;
import es.aesan.rgseaa.model.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionConverter extends BaseConverter<Action,ActionDto> {

}
