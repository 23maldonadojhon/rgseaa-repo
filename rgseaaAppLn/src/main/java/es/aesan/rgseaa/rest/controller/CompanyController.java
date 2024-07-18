package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.*;
import es.aesan.rgseaa.model.dto.*;
import es.aesan.rgseaa.service.facade.CompanyFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
