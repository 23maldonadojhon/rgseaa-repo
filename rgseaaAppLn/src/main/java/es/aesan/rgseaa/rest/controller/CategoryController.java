package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.dto.CategoryDto;
import es.aesan.rgseaa.service.facade.CategoryFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.CATEGORIES)
public class CategoryController extends AbstractController<
        CategoryDto,
        CategoryFacade,
        CategoryCriteria

        > {

    CategoryController(CategoryFacade facade) {
        super(facade);
    }


    @GetMapping(Url.ACTIVITIES + Url.LIST)
    public ResponseEntity<List<CategoryDto>> activityList(CategoryCriteria  categoryCriteria){
        logger.info("==== CONTROLLER -> LIST  :"+this.getClass().getSimpleName());

        List<CategoryDto> userPage = facade.list(categoryCriteria);
        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }

}
