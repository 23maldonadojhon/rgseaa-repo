package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.SubstanceConverter;
import es.aesan.rgseaa.model.dto.SubstanceDto;
import es.aesan.rgseaa.model.entity.Substance;
import es.aesan.rgseaa.service.service.SubstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubstanceFacade extends AbstractFacade<
        SubstanceDto,
        GeneralCriteria>  {

    private final SubstanceService substanceService;

    private final SubstanceConverter converter;

    @Override
    public void add(SubstanceDto dto) {
        Substance substance = converter.dtoToEntity(dto);
        substanceService.add(substance);
    }

    @Override
    public void update(SubstanceDto dto) {
        Substance substance = converter.dtoToEntity(dto);
        substanceService.update(substance);
    }

    @Override
    public Page<SubstanceDto> page(GeneralCriteria criteria) {
        Page<Substance> list = substanceService.page(criteria);
        Page<SubstanceDto> dtoList = converter.mapEntityToDtoPage(list);
        return dtoList;
    }

    @Override
    public SubstanceDto get(Long id) {
        Substance substance  = substanceService.get(id);
        SubstanceDto substanceDto = converter.entityToDto(substanceService.get(id));
        return substanceDto;
    }
}
