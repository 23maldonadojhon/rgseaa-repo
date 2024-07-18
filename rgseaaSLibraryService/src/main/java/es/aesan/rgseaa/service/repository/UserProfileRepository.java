package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserProfileRepository extends BaseRepository<UserProfile,Long> {

    @Query(value = "SELECT up FROM UserProfile up WHERE up.user.id=:IdUser")
    UserProfile getByUserId(@Param("IdUser") Long IdUser);
}
