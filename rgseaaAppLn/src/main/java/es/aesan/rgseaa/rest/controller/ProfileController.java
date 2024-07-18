package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.service.facade.ProfileFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.PROFILES)
public class ProfileController extends AbstractController<
        ProfileDto,
        ProfileFacade,
        GeneralCriteria
        > {

    ProfileController(ProfileFacade facade) {
        super(facade);
    }

}
