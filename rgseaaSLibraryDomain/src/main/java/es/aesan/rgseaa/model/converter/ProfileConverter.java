package es.aesan.rgseaa.model.converter;


import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {ProfilePermissionConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileConverter extends BaseConverter<Profile,ProfileDto> {


    ProfileDto entityToDto(Profile item);

}
