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


    ProfileDto entityToDto(Profile item);

}
