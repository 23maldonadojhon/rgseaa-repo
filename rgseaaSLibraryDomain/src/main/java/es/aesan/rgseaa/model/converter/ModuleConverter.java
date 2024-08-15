package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ModuleDto;
import es.aesan.rgseaa.model.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModuleConverter extends BaseConverter<Module,ModuleDto> {


    @Override
    ModuleDto entityToDto(Module item);


}
