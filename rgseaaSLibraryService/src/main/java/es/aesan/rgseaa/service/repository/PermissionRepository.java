package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.PermissionCriteria;
import es.aesan.rgseaa.model.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository
        extends BaseRepository<Permission, Long>,
        QueryByCriteria<Permission, PermissionCriteria> {

    @Query(value = "SELECT p FROM Permission p")
    Page<Permission> findAllByCriteria(PermissionCriteria criteria, Pageable pageable);

    @Query(value = "SELECT a FROM Permission a")
    List<Permission> findAll(PermissionCriteria criteria);

}
