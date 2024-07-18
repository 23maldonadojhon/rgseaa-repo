package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.UserEntitieCriteria;
import es.aesan.rgseaa.model.entity.UserEntitie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserEntitieRepository extends BaseRepository<UserEntitie,Long> {

    @Query(value = "SELECT e FROM UserEntitie e " +
            " WHERE " +
            " (:#{#criterial.userId} is null OR e.user.id=:#{#criterial.userId})")
    Page<UserEntitie> findAllByCriterial(@Param("criterial") UserEntitieCriteria criterial, Pageable pageable);

    @Query(value = "SELECT up FROM UserEntitie up WHERE up.user.id=:IdUser")
    Set<UserEntitie> getByUserId(@Param("IdUser") Long IdUser);
}
