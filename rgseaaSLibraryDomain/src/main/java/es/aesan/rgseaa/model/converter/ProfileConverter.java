package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.PermissionDto;
import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.entity.Profile;
import es.aesan.rgseaa.model.entity.ProfilePermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Mapper(componentModel = "spring",
        uses = {ProfilePermissionConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileConverter extends BaseConverter<Profile,ProfileDto> {



    @Override
    @Mapping(target ="permissions", expression = "java(getPermission(item.getProfilePermission()))")
    ProfileDto entityToDto(Profile item);


    default Set<PermissionDto> getPermission(Set<ProfilePermission> profilePermissions){

        Set<PermissionDto> permissionDtoSet = new HashSet<>();

        if(profilePermissions!=null){
            Iterator<ProfilePermission>  iterator = profilePermissions.iterator();


            while(iterator.hasNext()){
                ProfilePermission profilePermission = iterator.next();

                PermissionDto permissionDto = new PermissionDto();
                permissionDto.setId(profilePermission.getPermission().getId());
                permissionDto.setName(permissionDto.getName());
                permissionDtoSet.add(permissionDto);

            }
        }

        return permissionDtoSet;
    }

}
