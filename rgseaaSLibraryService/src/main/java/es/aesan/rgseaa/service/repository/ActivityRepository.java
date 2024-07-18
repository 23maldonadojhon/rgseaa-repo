package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.ActivityCriteria;
import es.aesan.rgseaa.model.entity.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository
        extends BaseRepository<Activity,Long>,
        QueryByCriteria<Activity, ActivityCriteria> {

        @Query(" SELECT a FROM Activity a WHERE a.code IN :activityList")
        List<Activity> findByActivity(@Param("activityList") List<String>  activityList);

        @Override
        @Query(value = " SELECT a FROM Activity a " +
                " WHERE " +
                " (:#{#criteria.code} IS NULL OR a.code = :#{#criteria.code})")
        Optional<Activity> find(ActivityCriteria criteria);

        @Override
        @Query(" SELECT a FROM Activity a " +
                " JOIN ActivityKey ak ON ak.activity.id = a.id " +
                " WHERE " +
                " (:#{#criteria.id} IS NULL OR a.id = :#{#criteria.id} ) " +
                " AND (:#{#criteria.keyId} IS NULL OR ak.key.id = :#{#criteria.keyId} ) ")
        Collection<Activity> findAll(ActivityCriteria criteria);
}
