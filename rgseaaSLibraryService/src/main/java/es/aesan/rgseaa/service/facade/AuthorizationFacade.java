package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.AuthorizationConverter;
import es.aesan.rgseaa.model.criteria.AuthorizationCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaAuthorizationCriteria;
import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.model.entity.Authorization;
import es.aesan.rgseaa.model.entity.RgseaaAuthorization;
import es.aesan.rgseaa.service.service.AuthorizationService;
import es.aesan.rgseaa.service.service.RgseaaAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorizationFacade extends AbstractFacade<
        AuthorizationDto,
        AuthorizationCriteria
        > {


    private final AuthorizationService service;
    private final RgseaaAuthorizationService rgseaaAuthorizationService;

    private final AuthorizationConverter converter;


    private static final Logger logger = LoggerFactory.getLogger(AuthorizationFacade.class);


    @Override
    public Page<AuthorizationDto> page(AuthorizationCriteria criteria){
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
    public List<AuthorizationDto> list(AuthorizationCriteria criteria) {
        logger.info("==== FACADE-> LIST ====");
        List<AuthorizationDto> dtoList;

        if(criteria.getRgseaaId()!=null){
            RgseaaAuthorizationCriteria rgseaaAuthorizationCriteria = new RgseaaAuthorizationCriteria();
            rgseaaAuthorizationCriteria.setRgseaaId(criteria.getRgseaaId());
            Collection<RgseaaAuthorization> rgseaaAuthorizationList = rgseaaAuthorizationService.list(rgseaaAuthorizationCriteria);
            List<Authorization> authorizationList = rgseaaAuthorizationList.stream().map(RgseaaAuthorization::getAuthorization).collect(Collectors.toList());
            dtoList = converter.mapEntityToDtoList(authorizationList);
        } else {
            Collection<Authorization> list = service.list(criteria);
            dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));
        }


        return dtoList;
    }

}
