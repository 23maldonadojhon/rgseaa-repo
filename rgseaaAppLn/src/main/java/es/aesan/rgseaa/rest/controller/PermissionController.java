package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.PermissionCriteria;
import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.service.facade.PermissionFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.PERMISSIONS)
public class PermissionController extends AbstractController<
        PermissionDto,
        PermissionFacade,
        PermissionCriteria> {


    PermissionController(PermissionFacade facade) {
        super(facade);
    }
}
