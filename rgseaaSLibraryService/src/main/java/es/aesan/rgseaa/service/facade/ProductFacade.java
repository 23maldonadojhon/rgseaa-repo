package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.criteria.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.model.util.exception.AppException;
import es.aesan.rgseaa.service.service.*;
import es.aesan.rgseaa.service.util.Accion;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class ProductFacade extends AbstractFacade<ProductDto,ProductCriteria> {

    private final KeyService keyService;
    private final FormPresentationService formPresentationService;
    private final DenominationSaleService denominationSaleService;
    private final SituationService situationService;
    private final CountryService countryService;
    private final EntitieService entitieService;
    private final TypeDocumentService typeDocumentService;
    private final ProductService productService;
    private final ActionService actionService;
    private final DocumentService documentService;
    private final TypeActionService typeActionService;

    private final KeyConverter keyConverter;
    private final FormPresentationConverter formPresentationConverter;
    private final DenominationSaleConverter denominationSaleConverter;
    private final SituationConverter situationConverter;
    private final CountryConverter countryConverter;
    private final EntitieConverter entitieConverter;
    private final TypeDocumentConverter typeDocumentConverter;
    private final ProductConverter productConverter;
    private final ActionConverter actionConverter;
    private final DocumentConverter documentConverter;
    private final TypeActionConverter typeActionConverter;

    private final FileUtilService fileUtilService;

    private static final Logger logger = LoggerFactory.getLogger(ProductFacade.class);


    @Override
    @Transactional
    public void add(ProductDto dto) {
        logger.info("==== FACADE-> ADD PRODUCT ====");

        valid(dto,Accion.ADD);

        Product product = productConverter.dtoToEntity(dto);
        Product productSaved = productService.add(product);

        saveAction(dto.getAction(),productSaved);
    }


    @Override
    @Transactional
    public void update(ProductDto dto) {
        logger.info("==== FACADE-> UPDATE PRODUCT ====");
        logger.info("user :"+dto);

        Product product = productConverter.dtoToEntity(dto);
        productService.update(product);

        saveAction(dto.getAction(),product);
    }

    @Override
    public ProductDto get(final Long id){
        logger.info("==== FACADE-> GET PRODUCT ====");

        Product product = productService.get(id);

        ActionCriteria criteria =null; //ActionCriteria.builder().productId(id).build();
        product.setAction(actionService.all(criteria));

        ProductDto productDto = productConverter.entityToDto(product);

        return productDto;
    }


    @Override
    public Page<ProductDto> page(ProductCriteria criteria){
        logger.info("==== FACADE-> getProductPage ====");
        Page<Product> page = productService.page(criteria);
        Page<ProductDto> dtoPage = productConverter.mapEntityToDtoPage(page);
        return dtoPage;
    }


    public void valid(ProductDto dto, final Accion accion){
        logger.info("==== FACADE->  VALID PRODUCT ====");

        if (accion.equals(Accion.ADD)) {

            boolean exist = productService.getByBrandExist(dto.getBrand());

            if(exist){
                String message = "El nombre del producto ya existe";
                logger.error("ERROR="+message);
                throw new AppException("001",message,message,null);
            }

        }

    }





    public Page<KeyDto> getKeyPage(GeneralCriteria criteria) {
        logger.info("==== FACADE-> getKeyPage ====");

        Page<Key> keyPage = keyService.page(criteria);

        return keyConverter.mapEntityToDtoPage(keyPage);
    }


    public Page<DenominationSaleDto> getDenominationSalePage(DenominationSaleCriterial criteria) {
        logger.info("==== FACADE-> getDenominationSalePage ====");

        Page<DenominationSale> denominationSalePage = denominationSaleService.page(criteria);

        return denominationSaleConverter.mapEntityToDtoPage(denominationSalePage);
    }


    public Page<SituationDto> getSituationPage(GeneralCriteria criteria) {
        logger.info("==== FACADE-> getSituationPage ====");

        Page<Situation> entitiePage = situationService.page(criteria);

        return situationConverter.mapEntityToDtoPage(entitiePage);
    }


    public List<DocumentDto> getDocumentList(DocumentCriteria criteria){
        logger.info("==== FACADE-> getDocumentList ====");

        List<Document> documentList = documentService.all(criteria);

        List<DocumentDto> documentDtoList = getDocumentDtoList(documentList);

        return documentDtoList;
    }


    public List<ActionDto> getListAction(ActionCriteria criteria){
        logger.info("==== FACADE-> getListAction ====");

        List<Action> actionList =  actionService.all(criteria);

        List<ActionDto> actionDtoList = actionConverter.mapEntityToDtoList(actionList);

        return actionDtoList;
    }


    public Page<CountryDto> getCountriesAvailablePage() {
        logger.info("==== FACADE-> getCountriesAvailablePage ====");

        Page<Country> entitiePage = countryService.getAllCountriesAvailable();

        return countryConverter.mapEntityToDtoPage(entitiePage);
    }


    public Page<FormPresentationDto> getFormPresentationPage(GeneralCriteria criteria) {
        logger.info("==== FACADE-> getFormPresentationPage ====");

        Page<FormPresentation> entitiePage = formPresentationService.page(criteria);

        return formPresentationConverter.mapEntityToDtoPage(entitiePage);
    }


    public Page<EntitieDto> getEntitiePage(EntitieCriteria criteria) {
        logger.info("==== FACADE-> getEntitiePage ====");

        Page<Entitie> entitiePage = entitieService.page(criteria);

        return entitieConverter.mapEntityToDtoPage(entitiePage);
    }



    public ActionDto getActionById(Long id) {
        logger.info("==== FACADE-> getActionById ====");
        Action action = actionService.get(id);
        ActionDto actionDto = actionConverter.entityToDto(action);
        return  actionDto;
    }



    public TypeActionDto getTypeActionById(Long id){
        logger.info("==== FACADE-> getTypeActionById ====");
        TypeAction typeAction = typeActionService.get(id);
        TypeActionDto typeActionDto = typeActionConverter.entityToDto(typeAction);
        return  typeActionDto;
    }





    private void saveAction(List<ActionDto> actionDtoList,Product productSaved){
        logger.info("==== FACADE-> saveAction ====");

        for(ActionDto actionDto : actionDtoList){

            if(actionDto.getId()==null){
                Action action  = actionConverter.dtoToEntity(actionDto);
                action.setProduct(productSaved);
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


}
