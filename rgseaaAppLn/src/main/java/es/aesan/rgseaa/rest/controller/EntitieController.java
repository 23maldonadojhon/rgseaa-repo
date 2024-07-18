package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.service.facade.EntitieFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.ENTITIES)
public class EntitieController extends AbstractController<
        EntitieDto,
        EntitieFacade,
        EntitieCriteria
        > {

    EntitieController(EntitieFacade facade) {
        super(facade);
    }

}
