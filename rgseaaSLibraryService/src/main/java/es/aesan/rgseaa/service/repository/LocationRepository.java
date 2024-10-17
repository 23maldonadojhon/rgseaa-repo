package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.LocationCriteria;
import es.aesan.rgseaa.model.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface LocationRepository
    extends BaseRepository<Location,Long>,
    QueryByCriteria<Location, LocationCriteria>{

    @Override
    @Query(value = "SELECT l  FROM Location l " +
            " WHERE " +
            " :#{#criteria.state} = l.state " +
            " AND (:#{#criteria.provinceId} IS NULL OR l.province.id = :#{#criteria.provinceId})")
    Page<Location> findAllByCriteria(LocationCriteria criteria, Pageable pageable);

    @Override
    @Query(value = "SELECT l  FROM Location l " +
            " WHERE " +
            " :#{#criteria.state} = l.state " +
            " AND (:#{#criteria.provinceId} IS NULL OR l.province.id = :#{#criteria.provinceId})")
    Collection<Location> findAll(LocationCriteria criteria);
}
