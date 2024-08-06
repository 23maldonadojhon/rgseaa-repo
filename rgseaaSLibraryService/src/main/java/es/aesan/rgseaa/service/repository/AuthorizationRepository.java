package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.AuthorizationCriteria;
import es.aesan.rgseaa.model.entity.Authorization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorizationRepository
        extends BaseRepository<Authorization,Long>,
        QueryByCriteria<Authorization, AuthorizationCriteria> {

    @Override
    @Query(value = "SELECT a FROM Authorization a")
    Page<Authorization> findAllByCriteria(AuthorizationCriteria criteria, Pageable pageable);

    @Query(value = "SELECT a FROM Authorization a")
    List<Authorization> findAll(AuthorizationCriteria criteria);
}
