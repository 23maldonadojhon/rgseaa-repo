package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.ProvinceCriteria;
import es.aesan.rgseaa.model.dto.ProvinceDto;
import es.aesan.rgseaa.service.facade.ProvinceFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.PROVINCES)
public class ProvinceController extends AbstractController<
        ProvinceDto,
        ProvinceFacade,
        ProvinceCriteria
        >{
    ProvinceController(ProvinceFacade facade) {
        super(facade);
    }
}
