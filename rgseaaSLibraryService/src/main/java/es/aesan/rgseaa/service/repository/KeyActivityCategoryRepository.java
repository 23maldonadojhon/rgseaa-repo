package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.KeyActivityCategoryCriteria;
import es.aesan.rgseaa.model.entity.KeyActivityCategory;
import es.aesan.rgseaa.model.entity.id.KeyActivityCategoryId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyActivityCategoryRepository
    extends BaseRepository<KeyActivityCategory,KeyActivityCategoryId>,
        QueryByCriteria<KeyActivityCategory, KeyActivityCategoryCriteria> {

    @Query(value = "SELECT k FROM KeyActivityCategory k" +
            " WHERE " +
            " (:#{#criteria.key} IS NULL OR k.id.key = :#{#criteria.key}) " +
            " AND" +
            " (:#{#criteria.activity} IS NULL OR k.id.activity = :#{#criteria.activity}) " +
            " AND" +
            " (:#{#criteria.category} IS NULL OR k.id.category = :#{#criteria.category}) " +
            " AND" +
            " (:#{#criteria.isVisibleRgsa} IS NULL OR k.isVisibleRgsa = :#{#criteria.isVisibleRgsa}) " +
            " AND" +
            " (:#{#criteria.isVisibleUe} IS NULL OR k.isVisibleUe = :#{#criteria.isVisibleUe}) ")
    List<KeyActivityCategory> findAllCriteria(@Param("criteria") KeyActivityCategoryCriteria criteria);

}
