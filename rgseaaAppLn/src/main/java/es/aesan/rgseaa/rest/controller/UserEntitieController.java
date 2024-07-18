package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.UserEntitieCriteria;
import es.aesan.rgseaa.model.dto.UserEntitieDto;
import es.aesan.rgseaa.service.facade.EntitieFacade;
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
@RequestMapping(Url.API+Url.USERS_ENTITIES)
public class UserEntitieController {

    @Autowired
    private EntitieFacade facade;

    private static final Logger logger = LoggerFactory.getLogger(UserEntitieController.class);


    @GetMapping
    public ResponseEntity<Page<UserEntitieDto>> entitieAll(UserEntitieCriteria criteria){
        logger.info("==== CONTROLLER-> GET ALL Entitie ====");

        Page<UserEntitieDto> page = facade.userEntitieByCriterial(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


}
