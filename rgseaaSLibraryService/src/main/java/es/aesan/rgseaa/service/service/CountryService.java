package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.service.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends AbstractService<Country,Long,CountryRepository,GeneralCriteria> {

    CountryService(CountryRepository repository){
        super(repository);
    }

    public Page<Country> getAllCountriesAvailable(){
        List<Country>  countryList = repository.getAllCountriesAvailable();
        Page<Country> countryPage = new PageImpl<>(countryList);
        return countryPage;
    }
}
