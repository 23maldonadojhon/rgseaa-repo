package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.PermissionConverter;
import es.aesan.rgseaa.model.criteria.PermissionCriteria;
import es.aesan.rgseaa.model.dto.AuthorizationDto;
import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.model.entity.Authorization;
import es.aesan.rgseaa.model.entity.Permission;
import es.aesan.rgseaa.service.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PermissionFacade extends  AbstractFacade<
        PermissionDto,
        PermissionCriteria> {

    @Autowired
    final private PermissionService permissionService;

    @Autowired
    final private PermissionConverter permissionConverter;


    private static final Logger logger = LoggerFactory.getLogger(PermissionFacade.class);


    public Page<PermissionDto> permissionAll(PermissionCriteria criteria){

        Page<Permission> page = permissionService.page(criteria);

        Page<PermissionDto> dtoPage = permissionConverter.mapEntityToDtoPage(page);

        return dtoPage;
    }

    @Override
    public List<PermissionDto> list(PermissionCriteria criteria) {
        logger.info("==== FACADE-> LIST ====");
        Collection<Permission> list = permissionService.list(criteria);

        List<PermissionDto> dtoList = permissionConverter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }
}
