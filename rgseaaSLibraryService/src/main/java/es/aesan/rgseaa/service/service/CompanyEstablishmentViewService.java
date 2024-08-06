package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import es.aesan.rgseaa.service.repository.CompanyEstablishmentViewRepository;
import es.aesan.rgseaa.service.repository.QueryByCriteria;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEstablishmentViewService extends AbstractService<
        CompanyEstablishmentView,
        Long,
        CompanyEstablishmentViewRepository,
        GeneralCriteria
        > {

    CompanyEstablishmentViewService(CompanyEstablishmentViewRepository repository) {
        super(repository);
    }


    public Page<CompanyEstablishmenInterface> pageCriteria(GeneralCriteria criteria){

        if(criteria.getState()==null)
            criteria.setState(1);

        if(criteria.getPage()==null)
            criteria.setPage(0);

        if(criteria.getSize()==null)
            criteria.setSize(10);

        Page<CompanyEstablishmenInterface> page =repository.findCriteria(criteria,criteria.toPageable());

        return page;
    }

}
