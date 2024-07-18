package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.entity.ProfilePermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProfilePermissionRepository extends BaseRepository<ProfilePermission, Long>{

    @Query(value = "SELECT pp FROM ProfilePermission pp WHERE pp.profile.id=:idProfile")
    Set<ProfilePermission> getByProfileId(@Param("idProfile") Long idProfile);
}
