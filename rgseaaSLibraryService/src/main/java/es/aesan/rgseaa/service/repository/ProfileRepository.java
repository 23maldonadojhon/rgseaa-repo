package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends BaseRepository<Profile,Long>, QueryByCriteria<Profile, GeneralCriteria> {


    @Query(value = "SELECT p FROM Profile p "
            + " WHERE "
            + " (COALESCE(:#{#criteria.state}, null) is null OR p.state IN (:#{#criteria.state}))"
            + " AND (:#{#criteria.name} is null OR UPPER(p.name) LIKE UPPER(:#{#criteria.name}))"
            + " AND ("
            + " :#{#criteria.search} IS null "
            + " OR UPPER(p.name) LIKE UPPER(:#{#criteria.search}) "
            + " )")
    Page<Profile> findAllByCriteria(@Param("criteria") GeneralCriteria criteria, Pageable pageable);

    Optional<Profile> findByName(String name);
}
