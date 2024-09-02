package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.RgseaaAuthorizationCriteria;
import es.aesan.rgseaa.model.entity.RgseaaAuthorization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RgseaaAuthorizationRepository
        extends BaseRepository<RgseaaAuthorization,Long>,
        QueryByCriteria<RgseaaAuthorization, RgseaaAuthorizationCriteria>{


    @Query(value = "SELECT a FROM RgseaaAuthorization a" +
            " WHERE " +
            " (:#{#criteria.rgseaaId} IS NULL OR a.rgseaa.id = :#{#criteria.rgseaaId}) "
    )
    List<RgseaaAuthorization> findAll(RgseaaAuthorizationCriteria criteria);

}
