package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.model.entity.UserProfile;
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
public class UserConverterImpl implements UserConverter {

    @Override
    public User dtoToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setState( dto.getState() );
        user.setId( dto.getId() );
        user.setNif( dto.getNif() );
        user.setName( dto.getName() );
        user.setFirstSurname( dto.getFirstSurname() );
        user.setSecondSurname( dto.getSecondSurname() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setProfile( profileDtoToUserProfile( dto.getProfile() ) );

        return user;
    }

    @Override
    public UserDto entityToDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setState( entity.getState() );
        userDto.setNif( entity.getNif() );
        userDto.setName( entity.getName() );
        userDto.setFirstSurname( entity.getFirstSurname() );
        userDto.setSecondSurname( entity.getSecondSurname() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPhone( entity.getPhone() );

        userDto.setProfile( getProfile(entity) );
        userDto.setEntity( getEntitie(entity) );

        return userDto;
    }

    @Override
    public List<UserDto> mapEntityToDtoList(List<User> lists) {
        if ( lists == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( lists.size() );
        for ( User user : lists ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }

    protected UserProfile profileDtoToUserProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        UserProfile userProfile = new UserProfile();

        userProfile.setState( profileDto.getState() );
        userProfile.setId( profileDto.getId() );

        return userProfile;
    }
}
