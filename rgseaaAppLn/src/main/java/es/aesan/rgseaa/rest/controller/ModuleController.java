package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.ModuleCriteria;
import es.aesan.rgseaa.model.dto.ModuleDto;
import es.aesan.rgseaa.service.facade.ModuleFacade;
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
@RequestMapping(Url.API+Url.MODULES)
public class ModuleController {

    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);


    @Autowired
    private ModuleFacade facade;


    @GetMapping
    public ResponseEntity<Page<ModuleDto>> getAll(ModuleCriteria criteria){
        logger.info("==== GET ALL Module ====");
        Page<ModuleDto> userPage;

        userPage = facade.moduleAll(criteria);

        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }

}
