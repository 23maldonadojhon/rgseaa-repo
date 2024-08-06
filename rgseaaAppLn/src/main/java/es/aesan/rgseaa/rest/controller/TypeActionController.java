package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.criteria.TypeActionCriteria;
import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.service.facade.TypeActionFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.TYPE_ACTIONS)
public class TypeActionController extends  AbstractController<
        TypeActionDto,
        TypeActionFacade,
        TypeActionCriteria
 >{
    TypeActionController(TypeActionFacade facade) {
        super(facade);
    }
}
