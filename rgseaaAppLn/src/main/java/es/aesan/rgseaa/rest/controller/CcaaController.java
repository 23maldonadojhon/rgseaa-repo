package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CcaaDto;
import es.aesan.rgseaa.service.facade.CcaaFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.CCAA)
public class CcaaController extends  AbstractController<
        CcaaDto,
        CcaaFacade,
        GeneralCriteria
        > {

    CcaaController(CcaaFacade facade) {
        super(facade);
    }
}
