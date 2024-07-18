package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.ModuleCriteria;
import es.aesan.rgseaa.model.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends  BaseRepository<Module,Long>, QueryByCriteria<Module, GeneralCriteria> {

    @Query(value = "SELECT t FROM Module t "
            + "WHERE "
            + "(:#{#criteria.name} is null OR UPPER(t.name) LIKE UPPER(:#{#criteria.name})) "
            + "AND (:#{#criteria.code} is null OR UPPER(t.code) LIKE UPPER(:#{#criteria.code})) "
            + "AND (:#{#criteria.moduleType} is null OR UPPER(t.name) LIKE UPPER(:#{#criteria.moduleType})) "
            + "AND (COALESCE(:#{#criteria.state}, null) is null OR t.state IN (:#{#criteria.state}))"
            + "AND ("
            + ":#{#criteria.search} is null "
            + "OR UPPER(t.code) LIKE UPPER(:#{#criteria.search}) "
            + "OR UPPER(t.name) LIKE UPPER(:#{#criteria.search}) "
            + "OR UPPER(t.name) LIKE UPPER(:#{#criteria.search}) "
            + ")"
    )
    Page<Module> findAllByCriteria(ModuleCriteria criteria, Pageable pageable);
}
