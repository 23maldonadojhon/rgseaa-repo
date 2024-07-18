package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CountryConverter;
import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.service.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryFacade extends AbstractFacade<
        CountryDto,
        GeneralCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(CountryFacade.class);

    private final CountryService countryService;

    private final CountryConverter countryConverter;

    @Override
    public List<CountryDto> list(GeneralCriteria criteria) {
        logger.info("==== FACADE-> getCountriesAvailableList ====");

        Collection<Country> entitieList = countryService.list(criteria);

        return countryConverter.mapEntityToDtoList(new ArrayList<>(entitieList));
    }
}
