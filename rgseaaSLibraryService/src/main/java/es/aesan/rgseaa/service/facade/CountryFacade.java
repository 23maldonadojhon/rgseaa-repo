package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CountryConverter;
import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.service.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    //private static final Logger logger = LoggerFactory.getLogger(CountryFacade.class);

    private final CountryService countryService;

    private final CountryConverter countryConverter;

    @Override
    public void add(CountryDto dto){
        Country country=countryConverter.dtoToEntity(dto);
        countryService.add(country);
    }

    @Override
    public void update(CountryDto dto){
        Country country=countryConverter.dtoToEntity(dto);
        countryService.update(country);
    }

    @Override
    public List<CountryDto> list(GeneralCriteria criteria) {
        Collection<Country> countryCollection=countryService.list(criteria);
        List<CountryDto> countryDtoList=countryConverter.mapEntityToDtoList(new ArrayList<>(countryCollection));
        return countryDtoList;
    }

    @Override
    public Page<CountryDto> page(GeneralCriteria criteria){
        Page<Country> countryPage = countryService.page(criteria);
        Page<CountryDto> countryDtoPage=countryConverter.mapEntityToDtoPage(countryPage);
        return countryDtoPage;
    }

    @Override
    public CountryDto get(Long id){
        Country country= countryService.get(id);
        CountryDto countryDto= countryConverter.entityToDto(countryService.get(id));
        return countryDto;
    }
}
