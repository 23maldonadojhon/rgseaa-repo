package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.EstablishmentCriteria;
import es.aesan.rgseaa.model.dto.EstablishmentDto;
import es.aesan.rgseaa.service.facade.EstablishmentFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.ESTABLISHMENTS)
public class EstablishmentController extends AbstractController<
        EstablishmentDto,
        EstablishmentFacade,
        EstablishmentCriteria
        > {

    EstablishmentController(EstablishmentFacade facade) {
        super(facade);
    }

}
