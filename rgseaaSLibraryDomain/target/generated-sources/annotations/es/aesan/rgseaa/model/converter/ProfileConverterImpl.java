package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.entity.Profile;
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
public class ProfileConverterImpl implements ProfileConverter {

    @Override
    public Profile dtoToEntity(ProfileDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setId( dto.getId() );
        profile.setName( dto.getName() );
        profile.setState( dto.getState() );

        return profile;
    }

    @Override
    public List<ProfileDto> mapEntityToDtoList(List<Profile> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfileDto> list = new ArrayList<ProfileDto>( entityList.size() );
        for ( Profile profile : entityList ) {
            list.add( entityToDto( profile ) );
        }

        return list;
    }

    @Override
    public List<Profile> mapDtoToEntityList(List<ProfileDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Profile> list = new ArrayList<Profile>( dtoList.size() );
        for ( ProfileDto profileDto : dtoList ) {
            list.add( dtoToEntity( profileDto ) );
        }

        return list;
    }

    @Override
    public ProfileDto entityToDto(Profile item) {
        if ( item == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.setId( item.getId() );
        profileDto.setState( item.getState() );
        profileDto.setName( item.getName() );

        profileDto.setPermissions( getPermission(item.getProfilePermission()) );

        return profileDto;
    }
}
