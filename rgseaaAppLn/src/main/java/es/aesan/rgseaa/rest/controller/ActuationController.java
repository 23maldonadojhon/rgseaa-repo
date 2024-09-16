package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.dto.ActuationDto;
import es.aesan.rgseaa.service.facade.ActuationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.ACTUATIONS)
public class ActuationController  extends  AbstractController<
        ActuationDto,
        ActuationFacade,
        ActuationCriteria
        > {

    ActuationController(ActuationFacade facade) {
        super(facade);
    }

}
