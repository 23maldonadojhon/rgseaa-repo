package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.dto.DenominationSaleDto;
import es.aesan.rgseaa.service.facade.DenominationSaleFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.DENOMINATION_SALES)
public class DenominationSalesController extends AbstractController<
        DenominationSaleDto,
        DenominationSaleFacade,
        DenominationSaleCriterial
        > {

    DenominationSalesController(DenominationSaleFacade facade) {
        super(facade);
    }
}
