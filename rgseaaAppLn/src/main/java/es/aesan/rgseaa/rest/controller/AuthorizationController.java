package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.AuthorizationCriteria;
import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.service.facade.AuthorizationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.AUTHORIZATIONS)
public class AuthorizationController extends AbstractController<
        AuthorizationDto,
        AuthorizationFacade,
        AuthorizationCriteria
        > {
    AuthorizationController(AuthorizationFacade facade) {
        super(facade);
    }
}
