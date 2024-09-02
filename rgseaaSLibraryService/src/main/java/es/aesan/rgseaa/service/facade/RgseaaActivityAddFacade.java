package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.*;
import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.dto.RgseaaActivityAddDto;
import es.aesan.rgseaa.model.dto.RgseaaActivityDto;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
@RequiredArgsConstructor
public class RgseaaActivityAddFacade extends AbstractFacade<
        RgseaaActivityAddDto,
        GeneralCriteria
        > {

    private final RgseaaActivityService rgseaaActivityService;
    private final RgseaaService rgseaaService;

    private final RgseaaActivityConverter rgseaaActivityConverter;
    private final KeyConverter keyConverter;
    private final ActivityConverter activityConverter;
    private final CategoryConverter categoryConverter;
    private final SubActivityConverter subActivityConverter;

    private static final Logger logger = LoggerFactory.getLogger(RgseaaActivityAddFacade.class);
    private final SubActivityService subActivityService;
    private final CompanyService companyService;
    private final EstablishmentService establishmentService;


    @Override
    @Transactional
    public void add(RgseaaActivityAddDto dto) {

        Rgseaa rgseaa = new Rgseaa();

        if(dto.getCompanyId()!=null){
            Company company = companyService.get(dto.getCompanyId());
            rgseaa.setCompany(company);
        }

        if(dto.getEstablishmentId()>0){
            Establishment establishment = establishmentService.get(dto.getEstablishmentId());
            rgseaa.setEstablishment(establishment);
        }

        Key key = keyConverter.dtoToEntity(dto.getRgseaaList().stream()
                .map(RgseaaActivityDto::getKey)
                .findFirst().get());

        rgseaa.setKey(key);

        List<RgseaaActivity> list = new ArrayList<>();

        dto.getRgseaaList().forEach(item->{

            Activity activity = activityConverter.dtoToEntity(item.getActivity());
            Category category = categoryConverter.dtoToEntity(item.getCategory());
            SubActivity subActivity = null;

            if(item.getSubActivity()==null)
                subActivity = subActivityService.get(0L);
            else
                subActivity = subActivityConverter.dtoToEntity(item.getSubActivity());

            RgseaaActivity rgseaaActivity = new RgseaaActivity();
            rgseaaActivity.setRgseaa(rgseaa);
            rgseaaActivity.setActivity(activity);
            rgseaaActivity.setCategory(category);
            rgseaaActivity.setSubActivity(subActivity);

            list.add(rgseaaActivity);

        });

        Rgseaa rgseaaSaved = rgseaaService.add(rgseaa);

        list.forEach(rgseaaActivityService::add);

    }


    @Override
    @Transactional
    public void update(RgseaaActivityAddDto dto) {

        Rgseaa rgseaa = rgseaaService.get(dto.getRgseaaId());
        rgseaa.setDateModification(LocalDate.now());

        RgseaaActivityCriteria rgseaaActivityCriteria = new RgseaaActivityCriteria();
        rgseaaActivityCriteria.setRgseaaId(rgseaa.getId());

        Collection<RgseaaActivity> list = rgseaaActivityService.list(rgseaaActivityCriteria);
        list.forEach(item->rgseaaActivityService.delete(item.getId()));

        List<RgseaaActivity> rgseaaActivityList = getActivityList(dto,rgseaa);

        rgseaaActivityList.forEach(rgseaaActivityService::add);
    }



    private Rgseaa getRgseaa(RgseaaActivityAddDto dto){
        Rgseaa rgseaa = new Rgseaa();

        if(dto.getCompanyId()!=null){
            Company company = companyService.get(dto.getCompanyId());
            rgseaa.setCompany(company);
        }

        if(dto.getEstablishmentId()>0){
            Establishment establishment = establishmentService.get(dto.getEstablishmentId());
            rgseaa.setEstablishment(establishment);
        }

        Key key = keyConverter.dtoToEntity(dto.getRgseaaList().stream()
                .map(RgseaaActivityDto::getKey)
                .findFirst().get());

        rgseaa.setKey(key);

        return rgseaa;
    }


    private List<RgseaaActivity> getActivityList(RgseaaActivityAddDto dto, Rgseaa rgseaa){

        List<RgseaaActivity> list = new ArrayList<>();

        dto.getRgseaaList().forEach(item->{

            Activity activity = activityConverter.dtoToEntity(item.getActivity());
            Category category = categoryConverter.dtoToEntity(item.getCategory());
            SubActivity subActivity = null;

            if(item.getSubActivity()==null)
                subActivity = subActivityService.get(0L);
            else
                subActivity = subActivityConverter.dtoToEntity(item.getSubActivity());

            RgseaaActivity rgseaaActivity = new RgseaaActivity();
            rgseaaActivity.setRgseaa(rgseaa);
            rgseaaActivity.setActivity(activity);
            rgseaaActivity.setCategory(category);
            rgseaaActivity.setSubActivity(subActivity);

            list.add(rgseaaActivity);

        });

        return list;
    }


}
