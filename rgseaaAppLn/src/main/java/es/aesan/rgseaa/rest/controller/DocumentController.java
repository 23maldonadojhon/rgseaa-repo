package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.DocumentCriteria;
import es.aesan.rgseaa.model.dto.DocumentDto;
import es.aesan.rgseaa.service.facade.DocumentFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.DOCUMENTS)
public class DocumentController extends  AbstractController<
        DocumentDto,
        DocumentFacade,
        DocumentCriteria
        > {

    DocumentController(DocumentFacade facade) {
        super(facade);
    }

}
