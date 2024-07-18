package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.ProvinceConverter;
import es.aesan.rgseaa.model.dto.ProvinceDto;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.service.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProvinceFacade  extends AbstractFacade<
        ProvinceDto,
        GeneralCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceFacade.class);



    private final ProvinceService provinceService;

    private final ProvinceConverter provinceConverter;

    @Override
    public List<ProvinceDto> list(GeneralCriteria criteria) {
        logger.info("==== FACADE-> getProvinceAvailablePage ====");

        Collection<Province> entitieList = provinceService.list(new GeneralCriteria());

        return provinceConverter.mapEntityToDtoList(new ArrayList<>(entitieList));
    }

}
