package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompanyEstablishmentFacade extends AbstractFacade<
        CompanyEstablishmentDto,
        GeneralCriteria
        > {

    private final CompanyService companyService;
    private final EstablishmentService establishmentService;
    private final SituationService situationService;
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final LocationService locationService;
    private final RgseaaService rgseaaService;
    private final CompanyAuthorizationService companyAuthorizationService;
    private final RgseaaActivityService rgseaaActivityService;
    private final CompanyActuationService companyActuationService;


    private final CompanyConverter companyConverter;
    private final EstablishmentConverter establishmentConverter;
    private final AuthorizationConverter authorizationConverter;
    private final ActionConverter actionConverter;
    private final CategoryConverter categoryConverter;
    private final ActivityConverter activityConverter;
    private final SubActivityConverter subActivityConverter;
    private final KeyConverter keyConverter;
    private final TypeActuationConverter typeActuationConverter;



    @Override
    public void add(CompanyEstablishmentDto companyEstablishmentDto) {

        EstablishmentDto dto = companyEstablishmentDto.getEstablishment();

        Establishment establishment = getValue(dto);
        Establishment establishmentSaved = establishmentService.add(establishment);

        Rgseaa rgseaa = getValueRgseaa(companyEstablishmentDto.getRgseaaActivityList());
        rgseaa.setEstablishment(establishmentSaved);

        List<CompanyAuthorization> companyAuthorizationList = getValueAuthorization(companyEstablishmentDto.getAuthorizationList(),establishmentSaved);
        companyAuthorizationList.forEach(companyAuthorizationService::add);

        List<CompanyActuation> companyActuationList = getCompanyActuation(companyEstablishmentDto.getTypeActuationList(),establishmentSaved);
        companyActuationList.forEach(companyActuationService::add);

        Rgseaa rgseaaSaved = rgseaaService.add(rgseaa);
        List<RgseaaActivity> rgseaaActivityList = getValueRgseaaActivity(companyEstablishmentDto.getRgseaaActivityList(),rgseaaSaved);
        rgseaaActivityList.forEach(rgseaaActivityService::add);

    }


    public void update(CompanyEstablishmentDto companyEstablishmentDto) {

        EstablishmentDto dto = companyEstablishmentDto.getEstablishment();

        Establishment establishment = getValue(dto);
        Establishment establishmentSaved = establishmentService.update(establishment);

        List<CompanyActuation> companyActuationList = getCompanyActuationUpdate(companyEstablishmentDto.getTypeActuationList(),establishmentSaved);
        companyActuationList.forEach(companyActuationService::add);
    }


    private Rgseaa getValueRgseaa(List<RgseaaActivityDto> dto) {

        Rgseaa rgseaa = new Rgseaa();

        Key key = keyConverter.dtoToEntity(dto.stream()
                .map(RgseaaActivityDto::getKey)
                .findFirst().get());

        rgseaa.setKey(key);

        return rgseaa;
    }

    private List<CompanyAuthorization> getValueAuthorization(List<AuthorizationDto> dto, Establishment establishment) {

        List<CompanyAuthorization> authorizationList = new ArrayList<>();

        dto.forEach(item->{
            Authorization authorization = authorizationConverter.dtoToEntity(item);

            CompanyAuthorization companyAuthorization = new CompanyAuthorization();
            companyAuthorization.setEstablishment(establishment);
            companyAuthorization.setAuthorization(authorization);

            authorizationList.add(companyAuthorization);
        });

        return authorizationList;
    }


    private List<RgseaaActivity>  getValueRgseaaActivity(List<RgseaaActivityDto>  rgseaaActivityDtoList, Rgseaa rgseaa) {

        List<RgseaaActivity> list = new ArrayList<>();

        rgseaaActivityDtoList.forEach(item->{
            Activity activity = activityConverter.dtoToEntity(item.getActivity());
            Category category = categoryConverter.dtoToEntity(item.getCategory());
            SubActivity subActivity = subActivityConverter.dtoToEntity(item.getSubActivity());

            RgseaaActivity rgseaaActivity = new RgseaaActivity();
            rgseaaActivity.setRgseaa(rgseaa);
            rgseaaActivity.setActivity(activity);
            rgseaaActivity.setCategory(category);
            rgseaaActivity.setSubActivity(subActivity);

            list.add(rgseaaActivity);
        });

        return list;
    }



    private Establishment getValue(EstablishmentDto dto) {

        Establishment establishment = establishmentConverter.dtoToEntity(dto);

        Situation situation = situationService.get(dto.getSituationId());
        Country country = countryService.get(dto.getCountryId());
        Company company = companyService.get(dto.getCompanyId());

        establishment.setSituation(situation);
        establishment.setCountry(country);
        establishment.setCompany(company);

        Optional.ofNullable(dto.getProvinceId())
                .map(provinceService::get)
                .ifPresent(establishment::setProvince);


        Optional.ofNullable(dto.getLocationId())
                .map(locationService::get)
                .ifPresent(establishment::setLocation);

        return establishment;

    }



    private List<CompanyActuation>  getCompanyActuation(List<TypeActuationDto> list, Establishment establishment) {

        List<CompanyActuation> companyActuationList = new ArrayList<>();

        list.forEach(item->{
            CompanyActuation companyActuation = new CompanyActuation();
            TypeActuation typeActuation = typeActuationConverter.dtoToEntity(item);
            companyActuation.setActuation(typeActuation);
            companyActuation.setEstablishment(establishment);
            companyActuationList.add(companyActuation);
        });

        return companyActuationList;
    }

    private List<TypeActuation> getValueTypeActuation(List<TypeActuationDto> dto) {

        List<TypeActuation> list = new ArrayList<>();

        dto.stream()
                .filter(TypeActuationDto::isSaved)
                .forEach(item -> {
                    TypeActuation typeActuation = typeActuationConverter.dtoToEntity(item);
                    list.add(typeActuation);
                });

        return list;
    }

    private List<CompanyActuation>  getCompanyActuationUpdate(List<TypeActuationDto> dto,  Establishment establishment) {

        List<CompanyActuation> companyActuationList = new ArrayList<>();

        getValueTypeActuation(dto).forEach(item->{
            CompanyActuation companyActuation = new CompanyActuation();
            companyActuation.setActuation(item);
            companyActuation.setEstablishment(establishment);
            companyActuationList.add(companyActuation);
        });

        return companyActuationList;
    }

}
