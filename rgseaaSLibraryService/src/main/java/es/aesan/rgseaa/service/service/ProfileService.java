package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.entity.Profile;
import es.aesan.rgseaa.service.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProfileService
        extends AbstractService<Profile, Long, ProfileRepository, FilterCriteria> {

    ProfileService(ProfileRepository repository){
        super(repository);
    }

    public Optional<Profile> getByName(final String name){
        logger.info("==== getByName Profile ====");
        logger.info("name :"+name);

        return repository.findByName(name) ;
    }

}
