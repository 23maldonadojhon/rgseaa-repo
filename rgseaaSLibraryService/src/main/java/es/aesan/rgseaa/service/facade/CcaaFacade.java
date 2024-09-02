package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CcaaConverter;
import es.aesan.rgseaa.model.criteria.CompanyCriteria;
import es.aesan.rgseaa.model.dto.CcaaDto;
import es.aesan.rgseaa.model.dto.CompanyDto;
import es.aesan.rgseaa.model.entity.Ccaa;
import es.aesan.rgseaa.service.service.CcaaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CcaaFacade extends AbstractFacade<
        CcaaDto,
        GeneralCriteria
        > {

    private final CcaaService ccaaService;

    private final CcaaConverter ccaaConverter;

    private static final Logger logger = LoggerFactory.getLogger(CompanyFacade.class);



    @Override
    public List<CcaaDto> list(GeneralCriteria criteria) {
        logger.info("==== FACADE-> PAGE LIST ====");

        Collection<Ccaa> ccaaList = ccaaService.list(criteria);
        List<CcaaDto> ccaaDtoList = ccaaConverter.mapEntityToDtoList(new ArrayList<>(ccaaList));

        return ccaaDtoList;
    }

}
