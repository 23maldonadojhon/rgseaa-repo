package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.EstablishmentConverter;
import es.aesan.rgseaa.model.criteria.EstablishmentCriteria;
import es.aesan.rgseaa.model.dto.EstablishmentDto;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.model.entity.Establishment;
import es.aesan.rgseaa.model.entity.Situation;
import es.aesan.rgseaa.model.entity.Company;
import es.aesan.rgseaa.service.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EstablishmentFacade  extends AbstractFacade<
        EstablishmentDto,
        EstablishmentCriteria
        >{

    private static final Logger logger = LoggerFactory.getLogger(CompanyFacade.class);

    private final EstablishmentService establishmentService;
    private final CompanyService companyService;
    private final SituationService situationService;
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final LocationService locationService;

    private final EstablishmentConverter establishmentConverter;

    @Override
    public void add(EstablishmentDto dto) {

        logger.info("==== FACADE-> ADD ESTABLISHMENT ====");

        Situation situation = situationService.get(dto.getSituationId());
        Country country = countryService.get(dto.getCountryId());
        Company company = companyService.get(dto.getCompanyId());

        Establishment establishment = establishmentConverter.dtoToEntity(dto);

        establishment.setSituation(situation);
        establishment.setCountry(country);
        establishment.setCompany(company);

        Optional.ofNullable(dto.getProvinceId())
                .map(provinceService::get)
                .ifPresent(establishment::setProvince);


        Optional.ofNullable(dto.getLocationId())
                .map(locationService::get)
                .ifPresent(establishment::setLocation);

        Establishment establishmentSaved = establishmentService.add(establishment);
    }

    @Override
    public List<EstablishmentDto> list(EstablishmentCriteria criteria) {

        Collection<Establishment> list = establishmentService.list(criteria);
        List<EstablishmentDto> dtoList = establishmentConverter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }


}
