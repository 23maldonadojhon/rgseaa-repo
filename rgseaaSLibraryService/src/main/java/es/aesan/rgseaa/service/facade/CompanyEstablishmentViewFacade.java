package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.CompanyEstablishmentCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.service.service.CompanyEstablishmentViewService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyEstablishmentViewFacade extends AbstractFacade<
        CompanyEstablishmentViewDto,
        CompanyEstablishmentCriteria
    > {

    private final CompanyEstablishmentViewService companyEstablishmentViewService;
    


    private static final Logger logger = LoggerFactory.getLogger(CompanyEstablishmentViewFacade.class);


    @Override
    public List<CompanyEstablishmentViewDto> list(CompanyEstablishmentCriteria criteria) {
        return super.list(criteria);
    }


    public Page<CompanyEstablishmenInterface> pageCriteria(CompanyEstablishmentCriteria criteria) {

        if(criteria.getSearch()!=null)
            criteria.setSearch("%"+criteria.getSearch()+"%");

        Page<CompanyEstablishmenInterface> dtoPage =  companyEstablishmentViewService.pageCriteria(criteria);
        return dtoPage;
    }
}
