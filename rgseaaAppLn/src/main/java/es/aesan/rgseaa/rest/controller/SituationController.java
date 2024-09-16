package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.SituationCriteria;
import es.aesan.rgseaa.model.dto.SituationDto;
import es.aesan.rgseaa.service.facade.SituationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.SITUATIONS)
public class SituationController extends AbstractController<
        SituationDto,
        SituationFacade,
        SituationCriteria
        > {

    SituationController(SituationFacade facade) {
        super(facade);
    }
}
