package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.ActivityKeyCriteria;
import es.aesan.rgseaa.model.entity.ActivityKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ActivityKeyRepository
        extends BaseRepository<ActivityKey,Long>,
        QueryByCriteria<ActivityKey, ActivityKeyCriteria> {

    @Override
    @Query(" SELECT ak FROM ActivityKey ak " +
            "WHERE :#{#criteria.state} = ak.state " +
            " AND (:#{#criteria.activityId} IS NULL OR ak.activity.id = :#{#criteria.activityId} ) "+
            " AND (:#{#criteria.keyId} IS NULL OR ak.key.id = :#{#criteria.keyId} ) ")
    Collection<ActivityKey> findAll(ActivityKeyCriteria criteria);


    @Override
    @Query(" SELECT ak FROM ActivityKey ak " +
            "WHERE :#{#criteria.state} = ak.state " +
            " AND (:#{#criteria.activityId} IS NULL OR ak.activity.id = :#{#criteria.activityId} ) "+
            " AND (:#{#criteria.keyId} IS NULL OR ak.key.id = :#{#criteria.keyId} ) ")
    Optional<ActivityKey> find(@Param("criteria") ActivityKeyCriteria criteria);
}
