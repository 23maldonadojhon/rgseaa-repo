package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.dto.RgseaaDto;
import es.aesan.rgseaa.service.facade.RgseaaFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.RGSEAA)
public class RgseaaController extends AbstractController<
        RgseaaDto,
        RgseaaFacade,
        RgseaaCriteria
        > {

    RgseaaController(RgseaaFacade facade) {
        super(facade);
    }
}
