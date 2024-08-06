package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.FormPresentationConverter;
import es.aesan.rgseaa.model.dto.FormPresentationDto;
import es.aesan.rgseaa.model.entity.FormPresentation;
import es.aesan.rgseaa.service.service.FormPresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FormPresentationFacade extends AbstractFacade<
        FormPresentationDto,
        GeneralCriteria> {

    private final FormPresentationService formPresentationService;

    private final FormPresentationConverter formPresentationConverter;

   @Override
    public void add(FormPresentationDto dto){
        FormPresentation formPresentation= formPresentationConverter.dtoToEntity(dto);
        formPresentationService.add(formPresentation);
    }

    @Override
    public Page<FormPresentationDto> page(GeneralCriteria criteria){
        Page<FormPresentation> page= formPresentationService.page(criteria);
        Page<FormPresentationDto> dtoPage=formPresentationConverter.mapEntityToDtoPage(page);
        return dtoPage;
    }
}
