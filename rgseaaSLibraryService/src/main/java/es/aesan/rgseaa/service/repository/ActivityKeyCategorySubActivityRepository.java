package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.ActivityKeyCategorySubActivityCriteria;
import es.aesan.rgseaa.model.entity.ActivityKeyCategorySubActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface ActivityKeyCategorySubActivityRepository
        extends BaseRepository<ActivityKeyCategorySubActivity,Long>,
        QueryByCriteria<ActivityKeyCategorySubActivity, ActivityKeyCategorySubActivityCriteria> {

    @Override
    @Query(" SELECT ak FROM ActivityKeyCategorySubActivity ak " +
            " WHERE (:#{#criteria.activityKeyCategoryId} IS NULL OR ak.activityKeyCategory.id = :#{#criteria.activityKeyCategoryId}) ")
    Collection<ActivityKeyCategorySubActivity> findAll(ActivityKeyCategorySubActivityCriteria criteria);

    @Override
    @Query(" SELECT ak FROM ActivityKeyCategorySubActivity ak " +
            " WHERE (:#{#criteria.activityKeyCategoryId} IS NULL OR ak.activityKeyCategory.id = :#{#criteria.activityKeyCategoryId}) ")
    Optional<ActivityKeyCategorySubActivity> find(ActivityKeyCategorySubActivityCriteria criteria);

}
