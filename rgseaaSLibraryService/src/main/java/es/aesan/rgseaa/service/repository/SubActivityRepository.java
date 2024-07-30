package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.SubActivityCriteria;
import es.aesan.rgseaa.model.entity.SubActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface SubActivityRepository
    extends BaseRepository<SubActivity,Long>,
    QueryByCriteria<SubActivity, SubActivityCriteria> {

    @Query(value = "SELECT c FROM SubActivity c WHERE c.id IN :list")
    List<SubActivity> findById(@Param("list") Collection<Long> list);

    @Query(value = "SELECT c FROM SubActivity c WHERE c.id IN :list")
    List<SubActivity> List(@Param("list") Collection<Long> list);

    @Query(value = "SELECT c FROM SubActivity c WHERE c.id IN :list")
    List<SubActivity> find(@Param("list") Collection<Long> list);
}
