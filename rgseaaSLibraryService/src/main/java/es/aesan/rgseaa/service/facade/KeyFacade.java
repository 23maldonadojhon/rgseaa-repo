package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.KeyConverter;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.service.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class KeyFacade extends AbstractFacade<
        KeyDto,
        GeneralCriteria
        > {

    @Autowired
    private final KeyService keyService;

    @Autowired
    private final KeyConverter keyConverter;


    //private static final Logger logger = LoggerFactory.getLogger(KeyFacade.class);


   /* @Override
    public List<KeyDto> list(GeneralCriteria criteria) {
        logger.info("====  FACADE->  KEY LIST CRITERIA {} ====",criteria);

        Collection<Key> list = service.list(criteria);
        List<KeyDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));

        return dtoList;
    }*/

    @Override
    public void add(KeyDto dto){
        Key key=keyConverter.dtoToEntity(dto);
        keyService.add(key);
    }
    @Override
    public List<KeyDto> list (GeneralCriteria criteria) {
        Collection<Key> list=keyService.list(criteria);
        List<KeyDto> keyDtoList = keyConverter.mapEntityToDtoList(new ArrayList<>(list));
        return keyDtoList;
    }
    @Override
    public Page<KeyDto> page(GeneralCriteria criteria) {
       //logger.info("====  FACADE->  KEY PAGE CRITERIA {} ====",criteria);

        Page<Key> page = keyService.page(criteria);
        Page<KeyDto> keyDtoPage = keyConverter.mapEntityToDtoPage(page);

        return keyDtoPage;
    }


  /*  @Override
    public KeyDto get(final Long id){
        logger.info("==== FACADE-> FIND BY KEY {}====",id);

        Key entity = service.get(id);
        KeyDto dto = converter.entityToDto(entity);
        return dto;
    }*/

}
