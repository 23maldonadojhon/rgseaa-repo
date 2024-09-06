package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.PermissionConverter;
import es.aesan.rgseaa.model.converter.ProfileConverter;
import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.entity.Permission;
import es.aesan.rgseaa.model.entity.Profile;
import es.aesan.rgseaa.model.entity.ProfilePermission;
import es.aesan.rgseaa.service.service.ProfilePermissionService;
import es.aesan.rgseaa.service.service.ProfileService;
import es.aesan.rgseaa.service.util.Accion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProfileFacade extends AbstractFacade<ProfileDto,GeneralCriteria> {

    @Autowired
    private final ProfileService profileService;

    @Autowired
    private final ProfilePermissionService profilePermissionService;

    @Autowired
    private final ProfileConverter profileConverter;

    @Autowired
    private final PermissionConverter permissionConverter;


    private static final Logger logger = LoggerFactory.getLogger(ProfileFacade.class);


    @Override
    @Transactional
    public void add(final ProfileDto dto){
        logger.info("==== FACADE-> ADD PROFILE ====");
        logger.info("profile :"+dto);

        valid(dto, Accion.ADD);

        List<PermissionDto> permissionDtoSet = new ArrayList<>(dto.getPermissions());

        List<Permission> permissionList = permissionConverter.mapDtoToEntityList(permissionDtoSet);

        Profile entity = profileConverter.dtoToEntity(dto);

        Profile entitySaved = profileService.add(entity);

        List<ProfilePermission> list = convertToProfilePermission(permissionList,entitySaved);

        profilePermissionService.addAll(list);

    }


    @Override
    public void update(ProfileDto dto) {
        logger.info("==== FACADE-> profile profileUpdate ====");

        Profile entity = profileConverter.dtoToEntity(dto);

        List<PermissionDto> permissionDtoSet = new ArrayList<>(dto.getPermissions());

        List<Permission> permissionList = permissionConverter.mapDtoToEntityList(permissionDtoSet);

        profilePermissionService.deleteByProfileId(dto.getId());

        Profile entitySaved = profileService.add(entity);

        List<ProfilePermission> list = convertToProfilePermission(permissionList,entitySaved);

        profilePermissionService.addAll(list);

    }

    @Override
    public ProfileDto get(Long id) {
        logger.info("==== FACADE-> profile profileById ====");

        Set<ProfilePermission> profilePermissionSet = profilePermissionService.getByProfileId(id);

        List<Permission> permissionList = profilePermissionSet.stream().map(ProfilePermission::getPermission).collect(Collectors.toList());

        Profile entity = profileService.get(id);

        entity.setPermission(permissionList);

        ProfileDto entityDto = profileConverter.entityToDto(entity);

        List<PermissionDto> permissionDtoList = permissionConverter.mapEntityToDtoList(permissionList);

        entityDto.setPermissions(permissionDtoList);
        return  entityDto;
    }



    @Override
    public Page<ProfileDto> page(GeneralCriteria criteria){

        Page<Profile> page = profileService.page(criteria);

        Page<ProfileDto> dtoPage = profileConverter.mapEntityToDtoPage(page);

        return dtoPage;
    }


    private void valid(final ProfileDto dto, final Accion accion){
        logger.info("==== FACADE-> PROCCESS VALID PROFILE ====");
        logger.info("accion :"+accion.name());

        if (accion.equals(Accion.ADD)) {

            Optional<Profile> optional = profileService.getByName(dto.getName());
            optional.ifPresent((value)->{throw new ResponseStatusException(HttpStatus.FOUND);});

        } else if (accion.equals(Accion.UPDATE)) {

            if (ObjectUtils.isNotEmpty(dto.getId()))
                throw new ResponseStatusException(HttpStatus.CONFLICT);

        }

    }


    private List<ProfilePermission> convertToProfilePermission(List<Permission> permissionSet, Profile profile){

        List<ProfilePermission> list = new ArrayList<>();

        permissionSet.forEach(item->{
            ProfilePermission record = new ProfilePermission();
            record.setPermission(item);
            record.setProfile(profile);
            list.add(record);
        });

        return list;
    }


}
