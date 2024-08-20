package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.SituationConverter;
import es.aesan.rgseaa.model.dto.SituationDto;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.service.service.SituationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SituationFacade extends AbstractFacade<
        SituationDto,
        GeneralCriteria
        > {

    //private static final Logger logger = LoggerFactory.getLogger(SituationFacade.class);

    private final SituationService situationService;

    private final SituationConverter situationConverter;

    @Override
    //@Transactional
    public void add(SituationDto dto) {
        Situation situation = situationConverter.dtoToEntity(dto);
        situationService.add(situation);

    }

    @Override
    public void update(SituationDto dto) {
        Situation situation = situationConverter.dtoToEntity(dto);
        situationService.update(situation);

    }

    @Override
    public List<SituationDto> list(GeneralCriteria criteria) {

        //  logger.info("==== FACADE-> getSituationPage ====");
        Collection<Situation> list = situationService.list(criteria);
        List<SituationDto> situationDtos = situationConverter.mapEntityToDtoList(new ArrayList<>(list));
        //return situationConverter.mapEntityToDtoList(new ArrayList<>(list));
        return situationDtos;
    }

    @Override
    public Page<SituationDto> page(GeneralCriteria criteria) {
        Page<Situation> page = situationService.page(criteria);
        Page<SituationDto> dtoPage = situationConverter.mapEntityToDtoPage(page);
        return dtoPage;
    }

    @Override
    public SituationDto get(Long id) {
        Situation situation = situationService.get(id);
        SituationDto situationDto = situationConverter.entityToDto(situationService.get(id));
        return situationDto;
    }


}

