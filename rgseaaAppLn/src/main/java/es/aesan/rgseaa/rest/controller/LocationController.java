package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.criteria.LocationCriteria;
import es.aesan.rgseaa.model.dto.LocationDto;
import es.aesan.rgseaa.service.facade.LocationFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.LOCATIONS)
public class LocationController extends  AbstractController<
        LocationDto,
        LocationFacade,
        LocationCriteria
        >{

    LocationController(LocationFacade facade) {
        super(facade);
    }
}
