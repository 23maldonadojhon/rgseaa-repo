package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.ActivityCriteria;
import es.aesan.rgseaa.model.dto.ActivityDto;
import es.aesan.rgseaa.service.facade.ActivityFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.ACTIVITIES)
public class ActivityController extends AbstractController<
        ActivityDto,
        ActivityFacade,
        ActivityCriteria
    >{

    ActivityController(ActivityFacade facade) {
        super(facade);
    }
}
