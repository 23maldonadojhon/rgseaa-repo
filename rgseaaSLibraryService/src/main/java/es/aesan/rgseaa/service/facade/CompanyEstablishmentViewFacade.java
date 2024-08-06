package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CompanyEstablishmentViewConverter;
import es.aesan.rgseaa.model.dto.CompanyEstablishmenInterface;
import es.aesan.rgseaa.model.dto.CompanyEstablishmentViewDto;
import es.aesan.rgseaa.model.entity.CompanyEstablishmentView;
import es.aesan.rgseaa.service.service.CompanyEstablishmentViewService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyEstablishmentViewFacade extends AbstractFacade<
        CompanyEstablishmentViewDto,
        GeneralCriteria
    > {

    private final CompanyEstablishmentViewService companyEstablishmentViewService;

    private final CompanyEstablishmentViewConverter companyEstablishmentViewConverter;


    private static final Logger logger = LoggerFactory.getLogger(CompanyEstablishmentViewFacade.class);


    @Override
    public List<CompanyEstablishmentViewDto> list(GeneralCriteria criteria) {
        return super.list(criteria);
    }


    public Page<CompanyEstablishmenInterface> pageCriteria(GeneralCriteria criteria) {

        //String[] words = criteria.getSearch().toUpperCase().split(" ");

        //List<String> wordsList = Arrays.stream(words).map(word -> "%"+word+"%").collect(Collectors.toList());

        if(criteria.getSearch()!=null)
            criteria.setSearch("%"+criteria.getSearch()+"%");

        Page<CompanyEstablishmenInterface> dtoPage =  companyEstablishmentViewService.pageCriteria(criteria);
        return dtoPage;
    }
}
