package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentDto;
import es.aesan.rgseaa.service.facade.CompanyEstablishmentFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.COMPANY_ESTABLISHMENTS)
public class CompanyEstablishmentController extends AbstractController<
        CompanyEstablishmentDto,
        CompanyEstablishmentFacade,
        GeneralCriteria
        > {
    CompanyEstablishmentController(CompanyEstablishmentFacade facade) {
        super(facade);
    }

}
