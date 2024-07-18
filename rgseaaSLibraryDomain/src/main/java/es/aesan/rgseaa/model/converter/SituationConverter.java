package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.SituationDto;
import es.aesan.rgseaa.model.entity.Situation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SituationConverter extends BaseConverter<Situation,SituationDto> {

}
