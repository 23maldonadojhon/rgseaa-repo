package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.CompanyEstablishmentCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.service.facade.CompanyEstablishmentViewFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.COMPANY_ESTABLISHMENTS_VIEW)
public class CompanyEstablishmentViewController extends AbstractController<
        CompanyEstablishmentViewDto,
        CompanyEstablishmentViewFacade,
        CompanyEstablishmentCriteria
        > {

    CompanyEstablishmentViewController(CompanyEstablishmentViewFacade facade) {
        super(facade);
    }


    @GetMapping(Url.PAGE_CRITERIA)
    public ResponseEntity<Page<CompanyEstablishmenInterface>> pageCriteria(CompanyEstablishmentCriteria criteria){
        logger.info("==== CONTROLLER -> PAGE  :"+this.getClass().getSimpleName());

        Page<CompanyEstablishmenInterface> userPage = facade.pageCriteria(criteria);
        return ResponseEntity.status(HttpStatus.OK).body(userPage);
    }

}
