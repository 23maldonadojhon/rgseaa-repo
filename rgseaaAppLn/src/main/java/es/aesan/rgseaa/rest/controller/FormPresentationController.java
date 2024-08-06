package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.FormPresentationDto;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.service.facade.FormPresentationFacade;
import es.aesan.rgseaa.service.facade.TypeActuationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+ Url.FORM_PRESENTATIONS)
public class FormPresentationController extends AbstractController<
        FormPresentationDto,
        FormPresentationFacade,
        GeneralCriteria>{
    FormPresentationController(FormPresentationFacade facade){super(facade);}
}
