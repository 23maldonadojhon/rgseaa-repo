package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.CompanyCriteria;
import es.aesan.rgseaa.model.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CompanyRepository
        extends BaseRepository<Company,Long>,
        QueryByCriteria<Company, CompanyCriteria>{

    @Query(value = "SELECT i FROM Company i" +
            " WHERE " +
            "(:#{#criteria.state} IS NULL OR i.state = :#{#criteria.state}) " +
            " AND (:#{#criteria.name} IS NULL OR i.name LIKE :#{#criteria.name}) "
        )
    Page<Company> findAllByCriteria(@Param("criteria") CompanyCriteria criteria, Pageable pageable);

    @Query(value = "SELECT i FROM Company i" +
            " WHERE " +
            "(:#{#criteria.state} IS NULL OR i.state = :#{#criteria.state}) " +
            " AND (:#{#criteria.name} IS NULL OR UPPER(i.name) LIKE UPPER(:#{#criteria.name})) "
    )
    List<Company> findAll(@Param("criteria") CompanyCriteria criteria);


    @Query(value = "SELECT i FROM Company i" +
            " WHERE " +
            " (:#{#criteria.nif} IS NULL OR i.nif LIKE :#{#criteria.nif}) "
    )
    Optional<Company> find(@Param("criteria") CompanyCriteria criteria);


    @Query(value = "SELECT i FROM Company i WHERE UPPER(i.name) LIKE :nameList")
    Set<Company> findAllNameLike(@Param("nameList") String nameList);
}
