package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.UserEntitieCriteria;
import es.aesan.rgseaa.model.commom.dto.StatusChange;
import es.aesan.rgseaa.model.converter.EntitieConverter;
import es.aesan.rgseaa.model.converter.EntitieTypeConverter;
import es.aesan.rgseaa.model.converter.UserEntitieConverter;
import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.model.dto.EntitieTypeDto;
import es.aesan.rgseaa.model.dto.UserEntitieDto;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.model.entity.EntitieType;
import es.aesan.rgseaa.model.entity.UserEntitie;
import es.aesan.rgseaa.service.service.EntitieService;
import es.aesan.rgseaa.service.service.EntitieTypeService;
import es.aesan.rgseaa.service.service.UserEntitieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EntitieFacade extends AbstractFacade<EntitieDto,EntitieCriteria> {

    @Autowired
    private final EntitieService entitieService;

    @Autowired
    private final UserEntitieService userEntitieService;

    @Autowired
    private final EntitieTypeService entitieTypeService;

    @Autowired
    private final  EntitieConverter entitieConverter;

    @Autowired
    private final EntitieTypeConverter entitieTypeConverter;

    @Autowired
    private final UserEntitieConverter userEntitieConverter;


    private static final Logger logger = LoggerFactory.getLogger(EntitieFacade.class);


    @Override
    @Transactional
    public void add(EntitieDto dto) {
        logger.info("==== FACADE-> Add Entitie ====");

        Entitie entitie = entitieMapper(dto);
        entitieService.add(entitie);
    }

    @Override
    public void update(EntitieDto dto) {
        logger.info("==== FACADE-> Update Entitie ====");

        Entitie entitie = entitieMapper(dto);
        entitieService.update(entitie);
    }

    @Override
    public EntitieDto get(Long id) {
        logger.info("==== FACADE-> Entitie entitieById ====");

        Entitie entity = entitieService.get(id);
        EntitieDto entityDto =  entitieConverter.entityToDto(entity);
        return entityDto;
    }

    @Override
    public Page<EntitieDto> page(EntitieCriteria criteria){
        logger.info("==== FACADE-> Entitie entitieAll ====");

        Page<Entitie> page = entitieService.page(criteria);
        Page<EntitieDto> dtoPage = entitieConverter.mapEntityToDtoPage(page);
        return dtoPage;
    }





    public Page<UserEntitieDto> userEntitieByCriterial(final UserEntitieCriteria criteria){
        logger.info("==== FACADE-> Entitie userEntitieByCriterial ====");

        Page<UserEntitie> page = userEntitieService.page(criteria);

        Page<UserEntitieDto> dtoPage = userEntitieConverter.mapEntityToDtoPage(page);

        return dtoPage;
    }

    public Page<EntitieTypeDto> entitieTypeAll(GeneralCriteria criteria){
        logger.info("==== FACADE-> Entitie entitieTypeAll ====");

        Page<EntitieType> page = entitieTypeService.page(criteria);
        Page<EntitieTypeDto> dtoPage = entitieTypeConverter.mapEntityToDtoPage(page);
        return dtoPage;
    }

    private Entitie entitieMapper(EntitieDto entitieDto) {

        Entitie entitie = entitieConverter.dtoToEntity(entitieDto);
        EntitieType entitieType = entitieTypeService.get(entitieDto.getEntityType().getId());

        entitie.setEntityType(entitieType);

        return entitie;
    }

}
