package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.CcaaConverter;
import es.aesan.rgseaa.model.dto.CcaaDto;
import es.aesan.rgseaa.model.entity.Ccaa;
import es.aesan.rgseaa.service.service.CcaaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CcaaFacade extends AbstractFacade<
        CcaaDto,
        GeneralCriteria
        > {

    private final CcaaService ccaaService;

    private final CcaaConverter ccaaConverter;

   private static final Logger logger = LoggerFactory.getLogger(CcaaFacade.class);



    @Override
    public void add(CcaaDto dto){
        Ccaa ccaa=ccaaConverter.dtoToEntity(dto);
        ccaaService.add(ccaa);
    }

    @Override
    public void update(CcaaDto dto){
        Ccaa ccaa=ccaaConverter.dtoToEntity(dto);
        ccaaService.update(ccaa);
    }
    @Override
    public List<CcaaDto> list(GeneralCriteria criteria) {
        logger.info("==== FACADE-> PAGE LIST ====");

        Collection<Ccaa> ccaaList = ccaaService.list(criteria);
        List<CcaaDto> ccaaDtoList = ccaaConverter.mapEntityToDtoList(new ArrayList<>(ccaaList));

        return ccaaDtoList;
    }

    @Override
    public Page<CcaaDto> page(GeneralCriteria criteria){
        Page<Ccaa> ccaaPage=ccaaService.page(criteria);
        Page<CcaaDto> ccaaDtoPage=ccaaConverter.mapEntityToDtoPage(ccaaPage);
        return ccaaDtoPage;
    }

    @Override
    public  CcaaDto get(Long id){
        Ccaa ccaa=ccaaService.get(id);
        CcaaDto ccaaDto=ccaaConverter.entityToDto(ccaaService.get(id));
        return  ccaaDto;
    }

}
