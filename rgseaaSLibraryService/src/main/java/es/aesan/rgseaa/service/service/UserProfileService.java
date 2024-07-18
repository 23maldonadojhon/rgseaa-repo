package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.entity.Profile;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.model.entity.UserProfile;
import es.aesan.rgseaa.service.repository.UserProfileRepository;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService
        extends AbstractService<UserProfile,Long,UserProfileRepository, FilterCriteria> {


    UserProfileService(UserProfileRepository repository){
        super(repository);
    }

    public UserProfile getByUserId(final Long userId){
        return repository.getByUserId(userId);
    }

    public UserProfile getProfile(User userSaved, Profile profile){

        UserProfile userProfile = new UserProfile();
        userProfile.setUser(userSaved);
        userProfile.setProfile(profile);

        return  userProfile;
    }

}
