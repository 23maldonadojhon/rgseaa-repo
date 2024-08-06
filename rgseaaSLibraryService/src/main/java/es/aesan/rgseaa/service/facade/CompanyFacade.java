package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.criteria.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import es.aesan.rgseaa.util.Actions;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyFacade extends AbstractFacade<
        CompanyDto,
        CompanyCriteria> {

    private final CompanyService companyService;
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final LocationService locationService;
    private final AuthorizationService authorizationService;
    private final ActionService actionService;
    private final DocumentService documentService;
    private final KeyService keyService;
    private final ActivityService activityService;
    private final CategoryService categoryService;
    private final SubActivityService subActivityService;
    private final KeyActivityCategoryService keyActivityCategoryService;
    private final ActivityKeyService activityKeyService;
    private final SituationService situationService;
    private final EstablishmentService establishmentService;
    private final RgseaaService rgseaaService;
    private final RgseaaActivityService rgseaaActivityService;
    private final CompanyAuthorizationService companyAuthorizationService;


    private final CountryConverter countryConverter;
    private final CompanyConverter companyConverter;
    private final ProvinceConverter provinceConverter;
    private final LocationConverter locationConverter;
    private final AuthorizationConverter authorizationConverter;
    private final ActionConverter actionConverter;
    private final DocumentConverter documentConverter;
    private final KeyConverter keyConverter;
    private final CategoryConverter categoryConverter;
    private final ActivityConverter activityConverter;
    private final SubActivityConverter subActivityConverter;
    private final EstablishmentConverter establishmentConverter;


    private final FileUtilService fileUtilService;

    private static final Logger logger = LoggerFactory.getLogger(CompanyFacade.class);



    @Override
    @Transactional
    public void add(CompanyDto dto) {
        logger.info("==== FACADE-> ADD INDUSTRY====");

        Company company = getValue(dto);
        Company companySaved = companyService.add(company);

        Rgseaa rgseaa = getValueRgseaa(dto);
        rgseaa.setCompany(companySaved);

        List<CompanyAuthorization> companyAuthorizationList = getValueAuthorization(dto,companySaved);
        companyAuthorizationList.forEach(companyAuthorizationService::add);

        Rgseaa rgseaaSaved = rgseaaService.add(rgseaa);
        List<RgseaaActivity> rgseaaActivityList = getValueRgseaaActivity(dto,rgseaaSaved);
        rgseaaActivityList.forEach(rgseaaActivityService::add);

    }


    @Override
    @Transactional
    public void update(CompanyDto dto) {
        logger.info("==== FACADE-> UPDATE INDUSTRY ====");
        logger.info("user :"+dto);

        Company company = getValue(dto);

        companyService.update(company);
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
        //dto.setEstablishment(dtoList);

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


    private void saveAction(List<ActionDto> actionDtoList,Company companySaved){
        logger.info("==== FACADE-> saveAction ====");

        for(ActionDto actionDto : actionDtoList){

            if(actionDto.getId()==null){
                Action action  = actionConverter.dtoToEntity(actionDto);
                action.setCompany(companySaved);
                Action actionSaved = actionService.add(action);
                saveDocuments(actionDto.getDocumentList(),actionSaved);
            } else {
                if(actionDto.getUpdate()!=null && actionDto.getUpdate()==1){
                    actionService.delete(actionDto.getId());
                } else {
                    Action action = actionService.get(actionDto.getId());
                    saveDocuments(actionDto.getDocumentList(),action);
                }
            }
        }

    }


    private void saveDocuments(List<DocumentDto> documentList, Action saved){
        logger.info("==== FACADE-> saveDocuments ====");

        if(documentList!=null) {
            for (DocumentDto documentDto : documentList) {

                if (documentDto.getId() == null) {
                    Document document = documentConverter.dtoToEntity(documentDto);
                    document.setAction(saved);
                    document.setPathFile(fileUtilService.saveFile(documentDto, saved.getId()));
                    documentService.add(document);
                }

                if(documentDto.getUpdate()!=null && documentDto.getUpdate()==1){
                    documentService.delete(documentDto.getId());
                }
            }
        }
    }


    public List<ActionDto> getListAction(ActionCriteria criteria) {
        logger.info("==== FACADE-> getListAction ====");

        List<Action> actionList =  actionService.all(criteria);

        List<ActionDto> actionDtoList = actionConverter.mapEntityToDtoList(actionList);

        return actionDtoList;
    }


    public List<DocumentDto> getDocumentList(DocumentCriteria criteria) {
        logger.info("==== FACADE-> getDocumentList ====");

        List<Document> documentList = documentService.all(criteria);

        List<DocumentDto> documentDtoList = getDocumentDtoList(documentList);

        return documentDtoList;
    }


    public List<CompanyFindDto> getFind(CompanyCriteria criteria) {
        logger.info("==== FACADE-> getFind ====");

        String[] words = criteria.getName().toUpperCase().split(" ");

        List<String> wordsList = Arrays.stream(words).map(word -> "%"+word+"%").collect(Collectors.toList());

        List<Company> set = companyService.findAllNameLike(wordsList);

        List<CompanyFindDto> response = companyConverter.dtoToEntityFindList(set);

        return response;
    }


    private List<DocumentDto> getDocumentDtoList(List<Document> documentList){
        logger.info("==== FACADE-> getDocumentDtoList ====");

        List<DocumentDto> documentDtoList = new ArrayList<>();

        for (Document document : documentList){
            DocumentDto documentDto = documentConverter.entityToDto(document);
            documentDto.setB64(getDocument(document));
            documentDtoList.add(documentDto);
        }

        return documentDtoList;
    }


    private B64EncodedFileDto getDocument(Document document){
        logger.info("==== FACADE-> getDocument ====");

        B64EncodedFileDto b64EncodedFileDto = new B64EncodedFileDto();
        b64EncodedFileDto.setData(fileUtilService.getFile(document.getPathFile()));
        b64EncodedFileDto.setName(fileUtilService.getNameFile(document.getPathFile()));
        return b64EncodedFileDto;
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


        Optional.ofNullable(dto.getLocationId())
                .map(locationService::get)
                .ifPresent(company::setLocation);

        return company;
    }



    private Rgseaa getValueRgseaa(CompanyDto dto) {

        Rgseaa rgseaa = new Rgseaa();

        Key key = keyConverter.dtoToEntity(dto.getRgseaaList().stream()
                .map(RgseaaActivityDto::getKey)
                .findFirst().get());

        rgseaa.setKey(key);

        return rgseaa;
    }


    private List<CompanyAuthorization>  getValueAuthorization(CompanyDto dto,  Company company) {

        List<CompanyAuthorization> authorizationList = new ArrayList<>();

        dto.getAuthorizationList().forEach(item->{
            Authorization authorization = authorizationConverter.dtoToEntity(item);

            CompanyAuthorization companyAuthorization = new CompanyAuthorization();
            companyAuthorization.setCompany(company);
            companyAuthorization.setAuthorization(authorization);

            authorizationList.add(companyAuthorization);
        });

        return authorizationList;
    }


    private List<RgseaaActivity>  getValueRgseaaActivity(CompanyDto dto,  Rgseaa rgseaa) {

        List<RgseaaActivity> list = new ArrayList<>();

        dto.getRgseaaList().forEach(item->{

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


}
