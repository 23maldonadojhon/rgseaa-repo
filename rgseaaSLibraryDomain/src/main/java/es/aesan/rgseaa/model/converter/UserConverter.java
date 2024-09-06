package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.EntitieDto;
import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.HashSet;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ProfileConverter.class,
                EntitieConverter.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    User dtoToEntity(UserDto dto);

    @Mapping(target = "profile",  expression  = "java(getProfile(entity))")
    @Mapping(target = "entity", expression = "java(getEntitie(entity))")
    UserDto entityToDto(User entity);


    List<UserDto> mapEntityToDtoList(List<User> lists);


    default EntitieDto getEntitie(User entity){

        EntitieDto entitieDto = new EntitieDto();

        if(entity.getEntitie()!=null){

            Entitie entitie = entity.getEntitie().iterator().next().getEntity();
            entitieDto.setId(entitie.getId());
            entitieDto.setName(entitie.getName());
            entitieDto.setState(entitie.getState());
        }
        return entitieDto;

    }

    default ProfileDto getProfile(User entity){

        ProfileDto profileDto = new ProfileDto();

        if( entity.getProfile()!=null){
            profileDto.setId(entity.getProfile().getProfile().getId());
            profileDto.setName(entity.getProfile().getProfile().getName());
            profileDto.setState(entity.getProfile().getProfile().getState());
        }

        return profileDto;
    }


    default Page<UserDto> mapEntityToDtoPage(Page<User> page) {
        List<UserDto> content = mapEntityToDtoList(page.getContent());
        return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
    }

}
