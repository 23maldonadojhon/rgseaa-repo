package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.TypeExpedientDto;
import es.aesan.rgseaa.service.facade.TypeExpedientFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.TYPE_EXPEDIENTS)
public class TypeExpedientController extends  AbstractController<
        TypeExpedientDto,
        TypeExpedientFacade,
        GeneralCriteria
        > {

    TypeExpedientController(TypeExpedientFacade facade) {
        super(facade);
    }
}
