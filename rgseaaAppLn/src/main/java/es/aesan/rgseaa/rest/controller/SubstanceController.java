package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.SubstanceDto;
import es.aesan.rgseaa.service.facade.SubstanceFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.SUBSTANCES)
public class SubstanceController extends  AbstractController<
        SubstanceDto,
        SubstanceFacade,
        GeneralCriteria
        > {

    SubstanceController(SubstanceFacade facade) {
        super(facade);
    }

}
