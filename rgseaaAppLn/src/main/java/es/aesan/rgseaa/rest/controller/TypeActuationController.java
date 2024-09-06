package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.criteria.TypeActuationCriteria;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.service.facade.TypeActuationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+ Url.TYPE_ACTUATIONS)
public class TypeActuationController extends AbstractController<
        TypeActuationDto,
        TypeActuationFacade,
        TypeActuationCriteria>{
    TypeActuationController(TypeActuationFacade facade){super(facade);}

    @GetMapping(Url.COMPANIES + Url.LIST)
    public ResponseEntity<List<TypeActuationDto>> activityList(ActuationCriteria criteria){
        logger.info("==== CONTROLLER -> LIST  :"+this.getClass().getSimpleName());

        List<TypeActuationDto> userPage = facade.listCompany(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }
}
