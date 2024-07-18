package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.DenominationSaleConverter;
import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.dto.DenominationSaleDto;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.entity.DenominationSale;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.service.service.DenominationSaleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DenominationSaleFacade extends AbstractFacade<
        DenominationSaleDto,
        DenominationSaleCriterial
        > {

    @Autowired
    private final DenominationSaleService service;

    @Autowired
    private final DenominationSaleConverter converter;


    private static final Logger logger = LoggerFactory.getLogger(DenominationSaleFacade.class);


    @Override
    public Page<DenominationSaleDto> page(DenominationSaleCriterial criteria) {
        logger.info("====  FACADE->  KEY CRITERIA {} ====",criteria);

        Page<DenominationSale> page = service.page(criteria);

        Page<DenominationSaleDto> pageDto = converter.mapEntityToDtoPage(page);

        return pageDto;
    }

    @Override
    public DenominationSaleDto get(final Long id){
        logger.info("==== FACADE-> FIND BY KEY {}====",id);

        DenominationSale entity = service.get(id);
        DenominationSaleDto dto = converter.entityToDto(entity);
        return dto;
    }
}
