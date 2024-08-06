package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.TypeActionCriteria;
import es.aesan.rgseaa.model.entity.TypeAction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public interface TypeActionRepository extends BaseRepository<TypeAction,Long>,
        QueryByCriteria<TypeAction, TypeActionCriteria> {

    @Query(value = "SELECT t FROM TypeAction t")
    Page<TypeAction> findAllByCriteria(TypeActionCriteria criteria, Pageable pageable);

}
