package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.CompanyCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.entity.RgseaaActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RgseaaActivityRepository
        extends BaseRepository<RgseaaActivity,Long>,
        QueryByCriteria<RgseaaActivity, RgseaaActivityCriteria>{


    @Query(value = "SELECT r FROM RgseaaActivity r" +
            " WHERE " +
            " (:#{#criteria.rgseaaId} IS NULL OR r.rgseaa.id = :#{#criteria.rgseaaId}) "
    )
    List<RgseaaActivity> findAll(@Param("criteria") RgseaaActivityCriteria criteria);
}
