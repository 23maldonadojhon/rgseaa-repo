package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.entity.Rgseaa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface RgseaaRepository
        extends BaseRepository<Rgseaa,Long>,
        QueryByCriteria<Rgseaa, RgseaaCriteria>{

    @Override
    @Query(value = "SELECT r FROM Rgseaa r " +
            " WHERE " +
            " (:#{#criteria.companyId} IS NULL OR r.company.id = :#{#criteria.companyId}) " +
            " AND (:#{#criteria.establishmentId} IS NULL OR r.establishment.id = :#{#criteria.establishmentId}) "
    )
    Optional<Rgseaa> find(RgseaaCriteria criteria);

    @Override
    @Query(value = "SELECT r FROM Rgseaa r " +
            " WHERE " +
            "(:#{#criteria.state} IS NULL OR r.state = :#{#criteria.state}) " +
            " AND (:#{#criteria.companyId} IS NULL OR r.company.id = :#{#criteria.companyId})" +
            " AND (:#{#criteria.establishmentId} IS NULL OR r.establishment.id = :#{#criteria.establishmentId}) "
    )
    Collection<Rgseaa> findAll(RgseaaCriteria criteria);
}
