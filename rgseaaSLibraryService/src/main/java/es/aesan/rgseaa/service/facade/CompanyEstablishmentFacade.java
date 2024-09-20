package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import es.aesan.rgseaa.service.util.Accion;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompanyEstablishmentFacade extends AbstractFacade<
        CompanyEstablishmentDto,
        GeneralCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(CompanyEstablishmentFacade.class);


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
    private final FileUtilService fileUtilService;
    private final DocumentService documentService;


    private final EstablishmentConverter establishmentConverter;
    private final CategoryConverter categoryConverter;
    private final ActivityConverter activityConverter;
    private final SubActivityConverter subActivityConverter;
    private final KeyConverter keyConverter;
    private final TypeActuationConverter typeActuationConverter;
    private final ActuationConverter actuationConverter;
    private final DocumentConverter documentConverter;
    private final RgseaaAuthorizationConverter rgseaaAuthorizationConverter;



    @Override
    public void add(CompanyEstablishmentDto companyEstablishmentDto) {

        EstablishmentDto dto = companyEstablishmentDto.getEstablishment();

        Establishment establishment = getValue(dto);
        Establishment establishmentSaved = establishmentService.add(establishment);

        Rgseaa rgseaaSaved = saveRgseaa(companyEstablishmentDto.getRgseaaList() ,establishmentSaved, Accion.ADD);

        saveActuation(companyEstablishmentDto.getActuationList(),establishmentSaved,Accion.ADD);

        saveAuthorization(companyEstablishmentDto.getAuthorizationList(),rgseaaSaved);

    }


    public void update(CompanyEstablishmentDto companyEstablishmentDto) {

        EstablishmentDto dto = companyEstablishmentDto.getEstablishment();

        Establishment establishment = getValue(dto);
        Establishment establishmentSaved = establishmentService.update(establishment);

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



    private void saveActuation(List<ActuationDto> actuationDtoList, Establishment establishmentSaved, Accion accion) {
        logger.info("==== FACADE-> saveActuation ====");

        for (ActuationDto actuationDto : actuationDtoList) {

            if (actuationDto.getId() == null) {

                Actuation actuation = actuationConverter.dtoToEntity(actuationDto);
                TypeActuation typeActuation = typeActuationConverter.dtoToEntity(actuationDto.getTypeActuation());
                actuation.setEstablishment(establishmentSaved);
                actuation.setTypeActuation(typeActuation);
                Actuation actionSaved = actuationService.add(actuation);

                saveDocuments(actuationDto.getDocumentList(), actionSaved);

            } else {

                if (actuationDto.getUpdate() != null && actuationDto.getUpdate() == 1) {
                    actuationService.delete(actuationDto.getId());
                } else {
                    Actuation actuation = actuationService.get(actuationDto.getId());
                    saveDocuments(actuationDto.getDocumentList(), actuation);
                }
            }
        }
    }

    private void saveAuthorization(List<RgseaaAuthorizationDto> authorizationDtoList, Rgseaa rgseaa) {

        List<RgseaaAuthorization> authorizationList = new ArrayList<>();

        authorizationDtoList.forEach(item->{
            RgseaaAuthorization rgseaaAuthorization = rgseaaAuthorizationConverter.dtoToEntity(item);
            rgseaaAuthorization.setRgseaa(rgseaa);
            authorizationList.add(rgseaaAuthorization);
        });

        authorizationList.forEach(rgseaaAuthorizationService::add);
    }

    private Rgseaa saveRgseaa(List<RgseaaActivityDto> rgseaaDtoList, Establishment companySaved, Accion accion) {

        logger.info("==== FACADE-> saveRgseaa ====");

        Rgseaa rgseaaSaved = null;

        if(Accion.ADD.equals(accion)) {

            KeyDto keyDto = rgseaaDtoList.stream().map(RgseaaActivityDto::getKey).findFirst().get();

            Rgseaa rgseaa = new Rgseaa();
            Key key = keyConverter.dtoToEntity(keyDto);
            rgseaa.setKey(key);
            rgseaa.setEstablishment(companySaved);
            rgseaa.setDateAnnotation(LocalDate.now());
            rgseaaSaved = rgseaaService.add(rgseaa);

            saveRgseaaActivity(keyDto.getId(),rgseaaDtoList,rgseaaSaved);

        } else  if(Accion.UPDATE.equals(accion)) {

        }

        return rgseaaSaved;
    }



    private void  saveRgseaaActivity(Long keyId,  List<RgseaaActivityDto> rgseaaDtoList,  Rgseaa rgseaaSaved) {

        rgseaaDtoList.stream()
            .filter(item-> Objects.equals(item.getKey().getId(), keyId))
            .forEach(item->{
                Activity activity = activityConverter.dtoToEntity(item.getActivity());
                Category category = categoryConverter.dtoToEntity(item.getCategory());
                SubActivity subActivity = subActivityConverter.dtoToEntity(item.getSubActivity());

                RgseaaActivity rgseaaActivity = new RgseaaActivity();
                rgseaaActivity.setRgseaa(rgseaaSaved);
                rgseaaActivity.setActivity(activity);
                rgseaaActivity.setCategory(category);
                rgseaaActivity.setSubActivity(subActivity);

                rgseaaActivityService.add(rgseaaActivity);

            });
    }


    private void saveDocuments(List<DocumentDto> documentList, Actuation saved){
        logger.info("==== FACADE-> saveDocuments ====");

        if(documentList!=null) {
            for (DocumentDto documentDto : documentList) {

                if (documentDto.getId() == null) {
                    Document document = documentConverter.dtoToEntity(documentDto);
                    document.setActuation(saved);
                    document.setPathFile(fileUtilService.saveFile(documentDto, saved.getId()));
                    documentService.add(document);
                }

                if(documentDto.getUpdate()!=null && documentDto.getUpdate()==1){
                    documentService.delete(documentDto.getId());
                }
            }
        }
    }

}
