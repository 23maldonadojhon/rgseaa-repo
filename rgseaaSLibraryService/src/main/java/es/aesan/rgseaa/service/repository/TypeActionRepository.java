package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeAction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public interface TypeActionRepository extends BaseRepository<TypeAction,Long>,
        QueryByCriteria<TypeAction, GeneralCriteria> {

    @Query(value = "SELECT t FROM TypeAction t")
    Page<TypeAction> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

}
