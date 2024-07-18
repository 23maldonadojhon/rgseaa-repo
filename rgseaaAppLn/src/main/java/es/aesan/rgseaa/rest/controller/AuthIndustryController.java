package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.service.facade.AuthorizationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.AUTH_INDUSTRY)
public class AuthIndustryController extends AbstractController<
        AuthorizationDto,
        AuthorizationFacade,
        GeneralCriteria
        > {

    AuthIndustryController(AuthorizationFacade facade) {
        super(facade);
    }


}
