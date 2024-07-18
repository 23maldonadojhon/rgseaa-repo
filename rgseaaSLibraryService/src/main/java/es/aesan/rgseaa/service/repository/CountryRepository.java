package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Country;
import es.aesan.rgseaa.model.entity.Situation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryRepository extends BaseRepository<Country,Long>, QueryByCriteria<Country, GeneralCriteria> {

    @Query(value = "SELECT c FROM Country c")
    Page<Country> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Query(value = "SELECT c FROM Country c WHERE c.enrollment!='NIN'")
    List<Country> getAllCountriesAvailable();

    @Query(value = "SELECT c FROM Country c")
    List<Country> findAll(GeneralCriteria criteria);
}
