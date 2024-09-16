package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.ActuationConverter;
import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.dto.ActuationDto;
import es.aesan.rgseaa.model.entity.Actuation;
import es.aesan.rgseaa.service.service.ActuationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ActuationFacade extends AbstractFacade<
        ActuationDto,
        ActuationCriteria
        > {

    private final ActuationService actuationService;

    private final ActuationConverter actuationConverter;

    private static final Logger logger = LoggerFactory.getLogger(ActuationFacade.class);


    @Override
    public List<ActuationDto> list(ActuationCriteria criteria) {
        logger.info("==== FACADE-> LIST ACTIVITIES====");

        ActuationCriteria criteriaSearch = new ActuationCriteria();
        criteriaSearch.setCompanyId(criteria.getCompanyId());

        if(criteria.getEstablishmentId()>0)
            criteriaSearch.setEstablishmentId(criteria.getEstablishmentId());

        Collection<Actuation> actuationCollection =  actuationService.list(criteriaSearch);
        List<ActuationDto> actuationDtoList = actuationConverter.mapEntityToDtoList(new ArrayList<>(actuationCollection));
        return actuationDtoList;
    }

}
