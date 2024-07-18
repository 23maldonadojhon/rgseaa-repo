package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.service.facade.KeyFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.KEYS)
public class KeyController extends AbstractController<
        KeyDto,
        KeyFacade,
        GeneralCriteria
        > {

    KeyController(KeyFacade facade) {
        super(facade);
    }
}
