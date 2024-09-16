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
    private final CcaaService ccaaService;
    private final LocationService locationService;
    private final RgseaaService rgseaaService;
    private final RgseaaAuthorizationService rgseaaAuthorizationService;
    private final RgseaaActivityService rgseaaActivityService;
    private final ActuationService actuationService;


    private final EstablishmentConverter establishmentConverter;
    private final AuthorizationConverter authorizationConverter;
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



        List<Actuation> actuationList = getCompanyActuation(companyEstablishmentDto.getTypeActuationList(),establishmentSaved);
        actuationList.forEach(actuationService::add);

        Rgseaa rgseaaSaved = rgseaaService.add(rgseaa);

        List<RgseaaAuthorization> rgseaaAuthorizationList = getValueAuthorization(companyEstablishmentDto.getAuthorizationList(),rgseaaSaved);
        rgseaaAuthorizationList.forEach(rgseaaAuthorizationService::add);

        List<RgseaaActivity> rgseaaActivityList = getValueRgseaaActivity(companyEstablishmentDto.getRgseaaActivityList(),rgseaaSaved);
        rgseaaActivityList.forEach(rgseaaActivityService::add);

    }


    public void update(CompanyEstablishmentDto companyEstablishmentDto) {

        EstablishmentDto dto = companyEstablishmentDto.getEstablishment();

        Establishment establishment = getValue(dto);
        Establishment establishmentSaved = establishmentService.update(establishment);

        List<Actuation> actuationList = getCompanyActuationUpdate(companyEstablishmentDto.getTypeActuationList(),establishmentSaved);
        actuationList.forEach(actuationService::add);
    }


    private Rgseaa getValueRgseaa(List<RgseaaActivityDto> dto) {

        Rgseaa rgseaa = new Rgseaa();

        Key key = keyConverter.dtoToEntity(dto.stream()
                .map(RgseaaActivityDto::getKey)
                .findFirst().get());

        rgseaa.setKey(key);

        return rgseaa;
    }

    private List<RgseaaAuthorization> getValueAuthorization(List<AuthorizationDto> dto, Rgseaa rgseaa) {

        List<RgseaaAuthorization> authorizationList = new ArrayList<>();

        dto.forEach(item->{
            Authorization authorization = authorizationConverter.dtoToEntity(item);

            RgseaaAuthorization rgseaaAuthorization = new RgseaaAuthorization();
            rgseaaAuthorization.setRgseaa(rgseaa);
            rgseaaAuthorization.setAuthorization(authorization);

            authorizationList.add(rgseaaAuthorization);
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
        establishment.setCompany(company);
        establishment.setCountry(country);

        Optional.ofNullable(dto.getProvinceId())
                .map(provinceService::get)
                .ifPresent(establishment::setProvince);

        Optional.ofNullable(dto.getCcaaId())
                .map(ccaaService::get)
                .ifPresent(establishment::setCcaa);

        Optional.ofNullable(dto.getLocationId())
                .map(locationService::get)
                .ifPresent(establishment::setLocation);

        return establishment;

    }



    private List<Actuation>  getCompanyActuation(List<TypeActuationDto> list, Establishment establishment) {

        List<Actuation> actuationList = new ArrayList<>();

        list.forEach(item->{
            Actuation actuation = new Actuation();
            TypeActuation typeActuation = typeActuationConverter.dtoToEntity(item);
            actuation.setTypeActuation(typeActuation);
            actuation.setEstablishment(establishment);
            actuationList.add(actuation);
        });

        return actuationList;
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

    private List<Actuation>  getCompanyActuationUpdate(List<TypeActuationDto> dto, Establishment establishment) {

        List<Actuation> actuationList = new ArrayList<>();

        getValueTypeActuation(dto).forEach(item->{
            Actuation actuation = new Actuation();
            actuation.setTypeActuation(item);
            actuation.setEstablishment(establishment);
            actuationList.add(actuation);
        });

        return actuationList;
    }

}
