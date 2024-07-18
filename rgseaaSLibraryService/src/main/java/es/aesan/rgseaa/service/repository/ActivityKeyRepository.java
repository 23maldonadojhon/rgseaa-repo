package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.entity.ActivityKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ActivityKeyRepository
        extends BaseRepository<ActivityKey,Long>,
        QueryByCriteria<ActivityKey, ActivityKeyCriteria> {

    @Override
    @Query(" SELECT ak FROM ActivityKey ak " +
            " WHERE " +
            " (:#{#criteria.activityId} IS NULL OR ak.activity.id = :#{#criteria.activityId} ) ")
    Collection<ActivityKey> findAll(ActivityKeyCriteria criteria);
}
