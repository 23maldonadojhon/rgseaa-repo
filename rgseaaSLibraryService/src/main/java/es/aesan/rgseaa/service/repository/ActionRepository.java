package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.ActionCriteria;
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository
        extends BaseRepository<Action, Long>,
        QueryByCriteria<Action, GeneralCriteria> {


    @Query(value = "SELECT f FROM Action f")
    Page<Action> findAllByCriteria(ActionCriteria criteria, Pageable pageable);


    @Query(value = " SELECT a FROM Action a " +
            " WHERE " +
            " (:#{#criteria.productId} IS NULL OR a.product.id = :#{#criteria.productId}) " +
            " AND " +
            " (:#{#criteria.industryId} IS NULL OR a.company.id = :#{#criteria.industryId}) "
    )
    List<Action> findAll(ActionCriteria criteria);

}
