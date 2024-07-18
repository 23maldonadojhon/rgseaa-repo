package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.ActionCriteria;
import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.criteria.DocumentCriteria;
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.criteria.ProductCriteria;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.service.facade.ProductFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.PRODUCTS)
public class ProductController extends AbstractController<
        ProductDto,
        ProductFacade,
        ProductCriteria
        > {


    ProductController(ProductFacade facade) {
        super(facade);
    }


    @GetMapping(Url.KEYS)
    public ResponseEntity<Page<KeyDto>> getKeyAll(GeneralCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getAllKeys ====");

        Page<KeyDto> dtoPage = facade.getKeyPage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.DENOMINATION_SALES)
    public ResponseEntity<Page<DenominationSaleDto>> getDenominationSaleAll(DenominationSaleCriterial criteria) {
        logger.info("==== CONTROLLER -> GET getAllDenominationSales ====");

        Page<DenominationSaleDto> dtoPage = facade.getDenominationSalePage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.SITUATIONS)
    public ResponseEntity<Page<SituationDto>> getSituationPage(GeneralCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getAllSituations ====");

        Page<SituationDto> dtoPage = facade.getSituationPage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.COUNTRIES)
    public ResponseEntity<Page<CountryDto>> getCountryAll() {
        logger.info("==== CONTROLLER -> GET getCountryAll ====");

        Page<CountryDto> dtoPage = facade.getCountriesAvailablePage();
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.FORM_PRESENTATIONS)
    public ResponseEntity<Page<FormPresentationDto>> getFormPresentationsAll(GeneralCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getFormPresentationsAll ====");

        Page<FormPresentationDto> dtoPage = facade.getFormPresentationPage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.ENTITIES)
    public ResponseEntity<Page<EntitieDto>> getEntitieAll(EntitieCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getEntitieAll ====");

        Page<EntitieDto> dtoPage = facade.getEntitiePage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.TYPE_DOCUMENT)
    public ResponseEntity<Page<TypeDocumentDto>> getTypeDocumentAll(GeneralCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getTypeDocumentAll ====");

        Page<TypeDocumentDto> dtoPage = facade.getTypeDocumentPage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dtoPage);
    }


    @GetMapping(Url.DOCUMENTS)
    public ResponseEntity<List<DocumentDto>> getDocumentAll(DocumentCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getDocumentAll ====");

        List<DocumentDto> response = facade.getDocumentList(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping(Url.ACTIONS)
    public ResponseEntity<List<ActionDto>> getActionAll(ActionCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getActionAll ====");

        List<ActionDto> response = facade.getListAction(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping(Url.ACTIONS+"/{id}")
    public ResponseEntity<ActionDto> getActionById(final @PathVariable Long id) {
        logger.info("==== CONTROLLER -> GET getActionById ====");

        ActionDto response = facade.getActionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(Url.TYPE_ACTIONS)
    public ResponseEntity<Page<TypeActionDto>> getTypeActionPage(GeneralCriteria criteria) {
        logger.info("==== CONTROLLER -> GET getTypeActionPage ====");

        Page<TypeActionDto> response = facade.getTypeActionPage(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping(Url.TYPE_ACTIONS+"/{id}")
    public ResponseEntity<TypeActionDto> getTypeActionById(final @PathVariable Long id) {
        logger.info("==== CONTROLLER -> GET getActionById ====");

        TypeActionDto response = facade.getTypeActionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
