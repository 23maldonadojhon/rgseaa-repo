package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.UserEntitieDto;
import es.aesan.rgseaa.model.entity.UserEntitie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.convert.EntityConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;



@Mapper(componentModel = "spring",
        uses = {UserConverter.class, EntityConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntitieConverter {


    @Mapping(target = "user",  source = "user.id")
    @Mapping(target = "entity",  source = "entity.id")
    @Mapping(target = "entityCode",  source = "entity.code")
    @Mapping(target = "entityName",   source  = "entity.code")
    @Mapping(target = "firstSurname",  source = "entity.contactPerson")
    UserEntitieDto entityToDto(UserEntitie entity);


    List<UserEntitieDto> mapEntityToDtoList(List<UserEntitie> entitylist);

    default Page<UserEntitieDto> mapEntityToDtoPage(Page<UserEntitie> entityPage) {
        List<UserEntitieDto> content = mapEntityToDtoList(entityPage.getContent());
        return new PageImpl<>(content, entityPage.getPageable(), entityPage.getTotalElements());
    }

}
