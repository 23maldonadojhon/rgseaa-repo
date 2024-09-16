package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.RgseaaAuthorizationCriteria;
import es.aesan.rgseaa.model.dto.RgseaaAuthorizationDto;
import es.aesan.rgseaa.service.facade.RgseaaAuthorizationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.RGSEAA_AUTHORIZATIONS)
public class RgseaaAuthorizationController extends AbstractController<
        RgseaaAuthorizationDto,
        RgseaaAuthorizationFacade,
        RgseaaAuthorizationCriteria
        > {
    RgseaaAuthorizationController(RgseaaAuthorizationFacade facade) {
        super(facade);
    }
}
