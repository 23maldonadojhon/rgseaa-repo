package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.TypeExpedientConverter;
import es.aesan.rgseaa.model.dto.TypeExpedientDto;
import es.aesan.rgseaa.model.entity.TypeExpedient;
import es.aesan.rgseaa.service.service.TypeExpedientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TypeExpedientFacade extends AbstractFacade<
        TypeExpedientDto,
        GeneralCriteria
    > {

    private final TypeExpedientService typeExpedientService;

    private final TypeExpedientConverter typeExpedientConverter;


    @Override
    public List<TypeExpedientDto> list(GeneralCriteria criteria) {
        Collection<TypeExpedient> typeExpedientList = typeExpedientService.list(criteria);
        List<TypeExpedientDto> typeExpedientDtos = typeExpedientConverter.mapEntityToDtoList(new ArrayList<>(typeExpedientList));
        return typeExpedientDtos;
    }

}
