package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.TypeActuationConverter;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.model.entity.TypeActuation;
import es.aesan.rgseaa.service.service.TypeActuationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeActuationFacade extends AbstractFacade<
        TypeActuationDto,
        GeneralCriteria> {

    private final TypeActuationService typeActuationService;

    private final TypeActuationConverter converter;

   @Override
    public void add(TypeActuationDto dto){
        TypeActuation typeActuation=converter.dtoToEntity(dto);
        typeActuationService.add(typeActuation);
    }

    @Override
    public Page<TypeActuationDto> page(GeneralCriteria criteria){
        Page<TypeActuation> list= typeActuationService.page(criteria);
        Page<TypeActuationDto> dtoList=converter.mapEntityToDtoPage(list);
        return dtoList;
    }
}
