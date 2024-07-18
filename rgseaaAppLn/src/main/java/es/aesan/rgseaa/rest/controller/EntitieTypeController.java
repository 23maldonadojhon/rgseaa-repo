package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.EntitieTypeDto;
import es.aesan.rgseaa.service.facade.EntitieFacade;
import es.aesan.rgseaa.service.service.FileUtilService;
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
@RequestMapping(Url.API+Url.ENTITIES_TYPE)
public class EntitieTypeController {

    private static final Logger logger = LoggerFactory.getLogger(FileUtilService.class);


    @Autowired
    private EntitieFacade facade;


    @GetMapping
    public ResponseEntity<Page<EntitieTypeDto>> getAll(GeneralCriteria criteria){
        logger.info("==== GET ALL EntitieTyp ====");
        Page<EntitieTypeDto> userPage;

        userPage = facade.entitieTypeAll(criteria);

        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }
}
