package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.entity.ProfilePermission;
import es.aesan.rgseaa.service.repository.ProfilePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class ProfilePermissionService
        extends AbstractService<ProfilePermission,Long,ProfilePermissionRepository, FilterCriteria> {

    ProfilePermissionService(ProfilePermissionRepository repository){
        super(repository);
    }

    public Set<ProfilePermission> getByProfileId(final Long idProfile){
        logger.info("==== getByProfileId ====");
        return repository.getByProfileId(idProfile);
    }

    public void deleteByProfileId(final Long idProfile){
        logger.info("==== deleteByProfileId ====");
        Set<ProfilePermission> dataSet = getByProfileId(idProfile);
        repository.deleteAll(dataSet);
    }


}
