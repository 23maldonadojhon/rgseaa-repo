package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.ActivityKeyCategoryCriteria;
import es.aesan.rgseaa.model.entity.ActivityKeyCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ActivityKeyCategoryRepository
        extends BaseRepository<ActivityKeyCategory,Long>,
        QueryByCriteria<ActivityKeyCategory, ActivityKeyCategoryCriteria> {

    @Override
    @Query(" SELECT akc FROM ActivityKeyCategory akc " +
            " WHERE " +
            " (:#{#criteria.activityKeyId} IS NULL OR akc.activityKey.id = :#{#criteria.activityKeyId}) ")
    Collection<ActivityKeyCategory> findAll(ActivityKeyCategoryCriteria criteria);


    @Override
    @Query(" SELECT ak FROM ActivityKeyCategory ak " +
            " WHERE " +
            " (:#{#criteria.activityKeyId} IS NULL OR ak.activityKey.id = :#{#criteria.activityKeyId} ) "+
            " AND (:#{#criteria.categoryId} IS NULL OR ak.category.id = :#{#criteria.categoryId} ) ")
    Optional<ActivityKeyCategory> find(ActivityKeyCategoryCriteria criteria);
}
