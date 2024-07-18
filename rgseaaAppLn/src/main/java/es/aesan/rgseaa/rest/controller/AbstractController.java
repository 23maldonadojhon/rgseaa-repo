package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.commom.dto.StatusChange;
import es.aesan.rgseaa.service.facade.CrudFacade;
import es.aesan.rgseaa.util.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;


public abstract class AbstractController<
            D,
            F extends CrudFacade<D,C>,
            C extends FilterCriteria
        > implements CrudController<D,C> {

    protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected F facade;

    AbstractController(F facade){
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<Void> add(final @RequestBody D dto) {
        logger.info("==== CONTROLLER -> ADD :"+this.getClass().getSimpleName());

        facade.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping
    public ResponseEntity<Void> update(final @RequestBody D dto) {
        logger.info("==== CONTROLLER -> UPDATE :"+this.getClass().getSimpleName());

        facade.update(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<D> get(final @PathVariable Long id) {
        logger.info("==== CONTROLLER -> GET :"+this.getClass().getSimpleName());

        D dto =  facade.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(Url.FIND)
    public ResponseEntity<D> find(C criteria) {
        logger.info("==== CONTROLLER -> FIND :"+this.getClass().getSimpleName());

        D dto =  facade.find(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(Url.LIST)
    public ResponseEntity<List<D>> list(C criteria){
        logger.info("==== CONTROLLER -> LIST  :"+this.getClass().getSimpleName());

        List<D> userPage = facade.list(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }

    @GetMapping(Url.PAGE)
    public ResponseEntity<Page<D>> page(C criteria){
        logger.info("==== CONTROLLER -> PAGE  :"+this.getClass().getSimpleName());

        Page<D> userPage = facade.page(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }

}
