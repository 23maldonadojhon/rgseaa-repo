package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.LocationCriteria;
import es.aesan.rgseaa.model.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository
    extends BaseRepository<Location,Long>,
    QueryByCriteria<Location, LocationCriteria>{

    @Override
    @Query(value = "SELECT l  FROM Location l ")
    Page<Location> findAllByCriteria(LocationCriteria criteria, Pageable pageable);
}
