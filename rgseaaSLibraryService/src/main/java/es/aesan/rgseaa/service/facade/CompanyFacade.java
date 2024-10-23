package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.criteria.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import es.aesan.rgseaa.service.util.Accion;
import es.aesan.rgseaa.util.Actions;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyFacade extends AbstractFacade<
        CompanyDto,
        CompanyCriteria> {

    private final ActuationService actuationService;
    private final CompanyService companyService;
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final LocationService locationService;
    private final AuthorizationService authorizationService;
    private final DocumentService documentService;
    private final KeyService keyService;
    private final ActivityService activityService;
    private final CategoryService categoryService;
    private final SubActivityService subActivityService;
    private final KeyActivityCategoryService keyActivityCategoryService;
    private final SituationService situationService;
    private final EstablishmentService establishmentService;
    private final RgseaaService rgseaaService;
    private final RgseaaActivityService rgseaaActivityService;
    private final RgseaaAuthorizationService rgseaaAuthorizationService;
    private final CcaaService ccaaService;
    private final FileUtilService fileUtilService;
    private final CompanySituationService companySituationService;


    private final CompanyConverter companyConverter;
    private final AuthorizationConverter authorizationConverter;
    private final RgseaaAuthorizationConverter rgseaaAuthorizationConverter;
    private final DocumentConverter documentConverter;
    private final KeyConverter keyConverter;
    private final CategoryConverter categoryConverter;
    private final ActivityConverter activityConverter;
    private final SubActivityConverter subActivityConverter;
    private final EstablishmentConverter establishmentConverter;
    private final TypeActuationConverter typeActuationConverter;
    private final ActuationConverter actuationConverter;


    private static final Logger logger = LoggerFactory.getLogger(CompanyFacade.class);



    @Override
    @Transactional
    public void add(CompanyDto dto) {
        logger.info("==== FACADE-> ADD INDUSTRY====");

        Company company = getValue(dto);

        Company companySaved = companyService.add(company);

        Rgseaa rgseaaSaved = saveRgseaa(dto.getRgseaaList(),companySaved,Accion.ADD);

        saveCompanySituation(companySaved,company.getSituation());

        saveActuation(dto.getActuationList(),companySaved,Accion.ADD);

        saveAuthorization(dto,rgseaaSaved);

    }


    @Override
    @Transactional
    public void update(CompanyDto dto) {
        logger.info("==== FACADE-> UPDATE INDUSTRY ====");
        logger.info("user :"+dto);

        Company company = getValue(dto);
        Company companyUpdated = companyService.update(company);


        //List<Actuation> actuationList = getCompanyActuationUpdate(dto,companyUpdated);
        //actuationList.forEach(companyActuationService::add);

    }


    @Override
    public CompanyDto get(Long id) {

        logger.info("==== FACADE-> GET INDUSTRY ====");

        Company company = companyService.get(id);

        CompanyDto dto = companyConverter.entityToDto(company);

        EstablishmentCriteria criteria = new EstablishmentCriteria();
        criteria.setCompanyId(id);
        Collection<Establishment> list = establishmentService.list(criteria);
        List<EstablishmentDto> dtoList = establishmentConverter.mapEntityToDtoList(new ArrayList<>(list));


        return  dto;
    }


    @Override
    public CompanyDto find(CompanyCriteria criteria) {

        logger.info("==== FACADE-> FIND INDUSTRY ====");

        Company company = companyService.find(criteria);

        CompanyDto dto = companyConverter.entityToDto(company);

        return  dto;

    }

    @Override
    public Page<CompanyDto> page(CompanyCriteria criteria) {
        logger.info("==== FACADE-> PAGE INDUSTRY ====");

        Page<Company> page = companyService.page(criteria);
        Page<CompanyDto> dtoPage = companyConverter.mapEntityToDtoPage(page);

        return dtoPage;
    }


    @Override
    public List<CompanyDto> list(CompanyCriteria criteria) {
        logger.info("==== FACADE-> PAGE LIST ====");

        Collection<Company> list = companyService.list(criteria);
        List<CompanyDto> dtoList = companyConverter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }

    public Page<AuthorizationDto> getAuthorizationPage(){
        logger.info("==== FACADE-> getAuthorization ====");

        Page<Authorization> entityList = authorizationService.page(new AuthorizationCriteria());

        return authorizationConverter.mapEntityToDtoPage(entityList);

    }


    public Page<KeyDto> getKeyPage(){
        logger.info("==== FACADE-> getAuthorization ====");

        Page<Key> entityList = keyService.page(new GeneralCriteria());

        return keyConverter.mapEntityToDtoPage(entityList);

    }


    public List<ActivityDto> getActivityList(ActivityCriteria criteria){
        logger.info("==== FACADE-> getActivityPage ====");

        KeyActivityCategoryCriteria keyActivityCategoryCriteria = null;
                /*
                KeyActivityCategoryCriteria.builder()
                .key(criteria.getId())
                .isVisibleRgsa(1)
                .build();
*/
        List<KeyActivityCategory> entityList = keyActivityCategoryService.list(keyActivityCategoryCriteria);

        List<String> codeFindList = entityList.stream().map(item->item.getId().getActivity()).collect(Collectors.toList());

        List<Activity> resultList = activityService.findByActivity(codeFindList);

        return activityConverter.mapEntityToDtoList(resultList);

    }


    public List<CategoryDto> getCategoryList(CategoryCriteria criteria) {
        logger.info("==== FACADE-> getCategoryList ====");

        Activity activity = activityService.get(criteria.getId());

        KeyActivityCategoryCriteria keyActivityCategoryCriteria = null;


        List<KeyActivityCategory> entityList = keyActivityCategoryService.list(keyActivityCategoryCriteria);

        List<Long> codeFindList = entityList.stream().map(item->item.getId().getCategory()).collect(Collectors.toList());

        List<Category> categoryList = categoryService.findById(codeFindList);

        return categoryConverter.mapEntityToDtoList(categoryList);
    }


    public List<SubActivityDto> getSubActivityList(SubActivityCriteria criteria) {
        logger.info("==== FACADE-> SubActivityCriteria ====");

        KeyActivityCategoryCriteria keyActivityCategoryCriteria = null;

        /*
        KeyActivityCategoryCriteria.builder()
                .category(criteria.getId())
                .isVisibleRgsa(1)
                .build();
*/
        List<KeyActivityCategory> entityList = keyActivityCategoryService.list(keyActivityCategoryCriteria);

        Set<Long> subActivitySet = entityList.stream().map(KeyActivityCategory::getSubActivity).collect(Collectors.toSet());

        List<SubActivity> subActivityList = subActivityService.findById(subActivitySet);

        return subActivityConverter.mapEntityToDtoList(subActivityList);
    }


    private void saveKeyActivityCategory(List<IndustryKeyActivityCategoryDto> list, Company company, Actions action){
        logger.info("==== FACADE-> saveKeyActivityCategory ====");

        if(Actions.ADD.equals(action)) {

            addKeyActivityCategory(list,company);

        } else if(Actions.EDIT.equals(action)) {
            Long industryId = company.getId();

            IndustryKeyActivityCategoryCriteria criteria = null;

            /*
            IndustryKeyActivityCategoryCriteria.
                    builder().idIndustry(industryId).build();
*/
            //List<IndustryKeyActivityCategory> deleteList = (List<IndustryKeyActivityCategory>) industryKeyActivityCategoryService.list(criteria);

            //deleteList.forEach(entity->industryKeyActivityCategoryService.delete(entity.getId()));

            addKeyActivityCategory(list,company);
        }

    }


    private void addKeyActivityCategory(List<IndustryKeyActivityCategoryDto> list, Company company){

        List<IndustryKeyActivityCategory> entityList = new ArrayList<>();

        for (IndustryKeyActivityCategoryDto dto : list) {

            IndustryKeyActivityCategory entity = new IndustryKeyActivityCategory();

            entity.setIdIndustry(company.getId());
            entity.setCodeActivity(dto.getActivity().getCode());
            entity.setIdKey(dto.getKey().getId());
            entity.setIdCategory(dto.getCategory().getId());
            entity.setIdSubActivity(dto.getSubActivity().getId());

            entityList.add(entity);
        }

        //industryKeyActivityCategoryService.addAll(entityList);
    }


    private void saveAuthorization(List<AuthorizationDto> authorizationList, Company company){
        logger.info("==== FACADE-> saveAuthorization ====");

        List<IndustryAuthorization> list = new ArrayList<>();

        for (AuthorizationDto dto : authorizationList){

            Authorization entity = authorizationConverter.dtoToEntity(dto);

            IndustryAuthorization item = new IndustryAuthorization();
            item.setAuthorization(entity);
            item.setCompany(company);

            list.add(item);
        }

        //industryAuthorizationService.addAll(list);

    }

    private Rgseaa saveRgseaa(List<RgseaaActivityDto> rgseaaDtoList, Company companySaved, Accion accion) {

        logger.info("==== FACADE-> saveRgseaa ====");

        Rgseaa rgseaaSaved = null;

        if(Accion.ADD.equals(accion)) {

            KeyDto keyDto = rgseaaDtoList.stream().map(RgseaaActivityDto::getKey).findFirst().get();

            Rgseaa rgseaa = new Rgseaa();
            Key key = keyConverter.dtoToEntity(keyDto);
            rgseaa.setKey(key);
            rgseaa.setCompany(companySaved);
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


    private void saveCompanySituation(Company company, Situation situation) {
        logger.info("==== FACADE-> saveCompanySituation ====");
        CompanySituation companySituation = new CompanySituation();
        companySituation.setCompany(company);
        companySituation.setSituation(situation);

        companySituationService.add(companySituation);
    }


    private void saveActuation(List<ActuationDto> actuationDtoList, Company companySaved, Accion accion){
        logger.info("==== FACADE-> saveActuation ====");

        for(ActuationDto actuationDto : actuationDtoList){

            if(actuationDto.getId()==null){

                Actuation actuation  = actuationConverter.dtoToEntity(actuationDto);
                TypeActuation typeActuation = typeActuationConverter.dtoToEntity(actuationDto.getTypeActuation());
                actuation.setCompany(companySaved);
                actuation.setTypeActuation(typeActuation);
                Actuation actionSaved = actuationService.add(actuation);
                saveDocuments(actuationDto.getDocumentList(),actionSaved);
            } else {

                if(actuationDto.getUpdate()!=null && actuationDto.getUpdate()==1){
                    actuationService.delete(actuationDto.getId());
                } else {
                    Actuation actuation = actuationService.get(actuationDto.getId());
                    saveDocuments(actuationDto.getDocumentList(),actuation);
                }
            }
        }

    }


    private void saveAuthorization(CompanyDto dto, Rgseaa rgseaa) {

        List<RgseaaAuthorization> authorizationList = new ArrayList<>();

        dto.getAuthorizationList().forEach(item->{
            RgseaaAuthorization rgseaaAuthorization = rgseaaAuthorizationConverter.dtoToEntity(item);
            rgseaaAuthorization.setRgseaa(rgseaa);
            authorizationList.add(rgseaaAuthorization);
        });

        authorizationList.forEach(rgseaaAuthorizationService::add);
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


    public List<ActuationDto> getListActuation(ActuationCriteria criteria) {
        logger.info("==== FACADE-> getListAction ====");

        Collection<Actuation> actuationList =  actuationService.list(criteria);
        List<ActuationDto> actuationDtoList = actuationConverter.mapEntityToDtoList(new ArrayList<>(actuationList));
        return actuationDtoList;
    }




    public List<CompanyFindDto> getFind(CompanyCriteria criteria) {
        logger.info("==== FACADE-> getFind ====");

        String[] words = criteria.getName().toUpperCase().split(" ");

        List<String> wordsList = Arrays.stream(words).map(word -> "%"+word+"%").collect(Collectors.toList());

        List<Company> set = companyService.findAllNameLike(wordsList);

        List<CompanyFindDto> response = companyConverter.dtoToEntityFindList(set);

        return response;
    }



    private Company getValue(CompanyDto dto) {

        Company company = companyConverter.dtoToEntity(dto);


        Situation situation = situationService.get(dto.getSituationId());
        Country country = countryService.get(dto.getCountryId());

        company.setSituation(situation);
        company.setCountry(country);

        Optional.ofNullable(dto.getProvinceId())
                .map(provinceService::get)
                .ifPresent(company::setProvince);

        Optional.ofNullable(dto.getCcaaId())
                .map(ccaaService::get)
                .ifPresent(company::setCcaa);

        Optional.ofNullable(dto.getLocationId())
                .map(locationService::get)
                .ifPresent(company::setLocation);

        return company;
    }





}
