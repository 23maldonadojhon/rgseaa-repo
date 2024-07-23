package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.EstablishmentCriteria;
import es.aesan.rgseaa.model.entity.Establishment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends BaseRepository<Establishment,Long>,
        QueryByCriteria<Establishment, EstablishmentCriteria> {


    @Query(value = " SELECT e FROM Establishment e " +
            " WHERE " +
            " (:#{#criteria.companyId} IS NULL OR e.company.id = :#{#criteria.companyId}) ")
    List<Establishment> findAll(@Param("criteria") EstablishmentCriteria criteria);
}
