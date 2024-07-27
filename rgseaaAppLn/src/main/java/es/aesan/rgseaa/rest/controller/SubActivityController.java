package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.SubActivityDto;
import es.aesan.rgseaa.service.facade.SubActivityFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.SUBACTIVITIES)
public class SubActivityController extends  AbstractController<
        SubActivityDto,
        SubActivityFacade,
        GeneralCriteria
        > {

    SubActivityController(SubActivityFacade facade) {
        super(facade);
    }

}
