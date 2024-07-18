package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.entity.UserEntitie;
import es.aesan.rgseaa.model.entity.UserScopeId;
import org.springframework.stereotype.Repository;


@Repository
public interface UserScopeRepository extends BaseRepository<UserEntitie, UserScopeId> {

}
