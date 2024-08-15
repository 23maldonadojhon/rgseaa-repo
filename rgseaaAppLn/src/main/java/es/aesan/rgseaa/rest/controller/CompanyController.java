package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.CompanyCriteria;
import es.aesan.rgseaa.model.dto.CompanyDto;
import es.aesan.rgseaa.service.facade.CompanyFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.COMPANIES)
public class CompanyController extends  AbstractController<
        CompanyDto,
        CompanyFacade,
        CompanyCriteria
        >{

    CompanyController(CompanyFacade facade) {
        super(facade);
    }

}
