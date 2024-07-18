package es.aesan.rgseaa.model.converter;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        uses = {ProfileConverter.class,PermissionConverter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfilePermissionConverter  {

    final public ProfilePermissionConverter INSTANCE = Mappers.getMapper(ProfilePermissionConverter.class);

}
