package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CcaaConverter;
import es.aesan.rgseaa.model.converter.ProvinceConverter;
import es.aesan.rgseaa.model.criteria.ProvinceCriteria;
import es.aesan.rgseaa.model.criteria.UserCriteria;
import es.aesan.rgseaa.model.dto.ProvinceDto;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.service.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProvinceFacade  extends AbstractFacade<
        ProvinceDto,
        ProvinceCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceFacade.class);



    @Autowired
    private final ProvinceService provinceService;

    @Autowired
    private final ProvinceConverter provinceConverter;

    @Autowired
    final private CcaaConverter ccaaConverter;



    @Override
    @Transactional
    public void  add(ProvinceDto dto){
        logger.info("--------FACADE-> ADD PROVINCE-----------");
        logger.info("Province.:"+dto);

        Province province=provinceConverter.dtoToEntity(dto);
        provinceService.add(province);

    }

    @Override
    public void update(ProvinceDto provinceDto){
        Province province=provinceConverter.dtoToEntity(provinceDto);
        provinceService.update(province);

    }

    @Override
    public ProvinceDto get(Long id){
        Province province=provinceService.get(id);
        ProvinceDto provinceDto= provinceConverter.entityToDto(provinceService.get(id));
        return provinceDto;
    }

    @Override
    public List<ProvinceDto> list(ProvinceCriteria criteria) {
        logger.info("Ojo con esta siguiente linea no me agarra el province criteria");
        Collection<Province> list=provinceService.list(criteria);
        List<ProvinceDto> provinceDtos= provinceConverter.mapEntityToDtoList(new ArrayList<>(list));
        return provinceDtos;
    }

    @Override
    public Page<ProvinceDto> page(ProvinceCriteria provinceCriteria){
        logger.info(("----FACADE-> PROVINCE CRITERIA"));
        logger.info("criteria:::"+provinceCriteria);
        Page<Province> provincePage=provinceService.page(provinceCriteria);
        Page<ProvinceDto> provinceDtos=provinceConverter.mapEntityToDtoPage(provincePage);
        return provinceDtos;


    }

}
