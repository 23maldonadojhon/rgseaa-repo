package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CountryDto;
import es.aesan.rgseaa.service.facade.CountryFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.COUNTRIES)
public class CountryController extends AbstractController<
        CountryDto,
        CountryFacade,
        GeneralCriteria
        > {

    CountryController(CountryFacade facade) {
        super(facade);
    }

}
