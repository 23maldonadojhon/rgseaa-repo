package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.entity.DenominationSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DenominationSaleRepository extends BaseRepository<DenominationSale,Long>, QueryByCriteria<DenominationSale, DenominationSaleCriterial> {

    @Query(value =  " SELECT d FROM DenominationSale d " +
                    " WHERE " +
                    " (:#{#criteria.idkey} IS NULL OR d.key.id = :#{#criteria.idkey} )")
    Page<DenominationSale> findAllByCriteria(DenominationSaleCriterial criteria, Pageable pageable);
}
