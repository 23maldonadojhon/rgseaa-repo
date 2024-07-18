package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface QueryByCriteria<E, F extends FilterCriteria> {

    @Query(value = "SELECT DUMMY FROM DUAL D", nativeQuery = true)
    Page<E> findAllByCriteria(@Param("criteria") F criteria, Pageable pageable);

    @Query(value = "SELECT DUMMY FROM DUAL D", nativeQuery = true)
    Collection<E> findAll(@Param("criteria") F criteria);

    @Query(value = "SELECT DUMMY FROM DUAL D", nativeQuery = true)
    Optional<E> find(@Param("criteria") F criteria);

}
