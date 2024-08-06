package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.model.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionConverter extends BaseConverter<Permission,PermissionDto> {


    @Override
    PermissionDto entityToDto(Permission entity);



    default Page<PermissionDto> mapEntityToDtoPage(Page<Permission> entityPage) {
        List<PermissionDto> content = mapEntityToDtoList(entityPage.getContent());
        return new PageImpl<>(content, entityPage.getPageable(), entityPage.getTotalElements());
    }
}
