package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.PermissionCriteria;
import es.aesan.rgseaa.model.entity.Permission;
import es.aesan.rgseaa.service.repository.PermissionRepository;
import org.springframework.stereotype.Service;


@Service
public class PermissionService extends AbstractService<Permission,Long,PermissionRepository,PermissionCriteria> {

    PermissionService(PermissionRepository repository){
        super(repository);
    }

}
