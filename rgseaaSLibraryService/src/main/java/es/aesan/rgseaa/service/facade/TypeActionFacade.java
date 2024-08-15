package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.TypeActionConverter;
import es.aesan.rgseaa.model.criteria.TypeActionCriteria;
import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.model.entity.TypeAction;
import es.aesan.rgseaa.service.service.TypeActionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeActionFacade extends AbstractFacade<
        TypeActionDto,
        TypeActionCriteria>{

    private static final Logger logger = LoggerFactory.getLogger(TypeActionFacade.class);

    private final TypeActionService typeActionService;
    private final TypeActionConverter typeActionConverter;


    @Override
    public TypeActionDto get(Long id) {
        TypeAction item = typeActionService.get(id);
        TypeActionDto dto = typeActionConverter.entityToDto(item);
        return dto;
    }

    @Override
    public TypeActionDto find(TypeActionCriteria criteria) {
       return null;
    }

    @Override
    public Page<TypeActionDto> page(TypeActionCriteria criteria) {
        return null;
    }

}
