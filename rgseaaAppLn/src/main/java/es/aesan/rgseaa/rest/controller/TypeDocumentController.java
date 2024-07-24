package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.service.facade.TypeDocumentFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+ Url.TYPE_DOCUMENTS)
public class TypeDocumentController extends AbstractController<
        TypeDocumentDto,
        TypeDocumentFacade,
        GeneralCriteria>{
    TypeDocumentController(TypeDocumentFacade facade){super(facade);}
}
