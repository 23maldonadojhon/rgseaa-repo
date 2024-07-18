package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.AuthorizationConverter;
import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.model.entity.Authorization;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.service.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorizationFacade extends AbstractFacade<
        AuthorizationDto,
        GeneralCriteria
        > {

    @Autowired
    private final AuthorizationService service;

    @Autowired
    private final AuthorizationConverter converter;


    private static final Logger logger = LoggerFactory.getLogger(AuthorizationFacade.class);

    @Override
    public Page<AuthorizationDto> page(GeneralCriteria criteria){
        logger.info("====  FACADE ->  PAGE ====");
        logger.info("criteria :"+criteria);

        Page<Authorization> page = service.page(criteria);

        Page<AuthorizationDto> dtoPage = converter.mapEntityToDtoPage(page);

        return dtoPage;
    }


    @Override
    public AuthorizationDto get(final Long id){
        logger.info("==== FACADE-> FIND BY ID ====");
        logger.info("id :"+id);

        Authorization entity = service.get(id);
        AuthorizationDto dto = converter.entityToDto(entity);
        return dto;
    }

    @Override
    public List<AuthorizationDto> list(GeneralCriteria criteria) {
        logger.info("==== FACADE-> LIST ====");
        Collection<Authorization> list = service.list(criteria);

        List<AuthorizationDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }

}
