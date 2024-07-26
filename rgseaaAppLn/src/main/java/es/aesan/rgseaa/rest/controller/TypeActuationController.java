package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.service.facade.TypeActuationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+ Url.TYPE_ACTUATIONS)
public class TypeActuationController extends AbstractController<
        TypeActuationDto,
        TypeActuationFacade,
        GeneralCriteria>{
    TypeActuationController(TypeActuationFacade facade){super(facade);}
}
