package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.criteria.ProductCriteria;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.service.facade.ProductFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
