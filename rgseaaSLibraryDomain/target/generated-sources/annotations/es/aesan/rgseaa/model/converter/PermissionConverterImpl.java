package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.model.entity.Permission;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T08:06:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class PermissionConverterImpl implements PermissionConverter {

    @Override
    public Permission dtoToEntity(PermissionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setState( dto.getState() );
        permission.setId( dto.getId() );
        permission.setCode( dto.getCode() );
        permission.setName( dto.getName() );
        permission.setDescription( dto.getDescription() );

        return permission;
    }

    @Override
    public List<PermissionDto> mapEntityToDtoList(List<Permission> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PermissionDto> list = new ArrayList<PermissionDto>( entityList.size() );
        for ( Permission permission : entityList ) {
            list.add( entityToDto( permission ) );
        }

        return list;
    }

    @Override
    public List<Permission> mapDtoToEntityList(List<PermissionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Permission> list = new ArrayList<Permission>( dtoList.size() );
        for ( PermissionDto permissionDto : dtoList ) {
            list.add( dtoToEntity( permissionDto ) );
        }

        return list;
    }

    @Override
    public PermissionDto entityToDto(Permission entity) {
        if ( entity == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setId( entity.getId() );
        permissionDto.setState( entity.getState() );
        permissionDto.setCode( entity.getCode() );
        permissionDto.setName( entity.getName() );
        permissionDto.setDescription( entity.getDescription() );

        return permissionDto;
    }
}
