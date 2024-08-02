package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.PermissionCriteria;
import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.service.facade.PermissionFacade;
import es.aesan.rgseaa.util.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
