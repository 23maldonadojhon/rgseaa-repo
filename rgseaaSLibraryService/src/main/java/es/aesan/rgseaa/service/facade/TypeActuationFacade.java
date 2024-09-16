package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.TypeActuationConverter;
import es.aesan.rgseaa.model.criteria.TypeActuationCriteria;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.model.entity.TypeActuation;
import es.aesan.rgseaa.service.service.ActuationService;
import es.aesan.rgseaa.service.service.TypeActuationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TypeActuationFacade extends AbstractFacade<
        TypeActuationDto,
        TypeActuationCriteria> {

    private final TypeActuationService typeActuationService;
   private final ActuationService actuationService;

    private final TypeActuationConverter converter;




    @Override
    public void add(TypeActuationDto dto){
        TypeActuation typeActuation=converter.dtoToEntity(dto);
        typeActuationService.add(typeActuation);
    }

    @Override
    public  void update(TypeActuationDto dto){
        TypeActuation typeActuation= converter.dtoToEntity(dto);
        typeActuationService.update(typeActuation);
    }

    @Override
    public List<TypeActuationDto> list(TypeActuationCriteria criteria) {
        Collection<TypeActuation> list = typeActuationService.list(criteria);
        List<TypeActuationDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }

    @Override
    public Page<TypeActuationDto> page(TypeActuationCriteria criteria){
        Page<TypeActuation> list= typeActuationService.page(criteria);
        Page<TypeActuationDto> dtoList=converter.mapEntityToDtoPage(list);
        return dtoList;
    }

    @Override
    public TypeActuationDto get(Long id){
        TypeActuation typeActuation = typeActuationService.get(id);
        TypeActuationDto typeActuationDto=converter.entityToDto(typeActuationService.get(id));
        return  typeActuationDto;
    }


}
