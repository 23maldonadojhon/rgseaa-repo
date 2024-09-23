package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Ccaa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcaaRepository extends BaseRepository<Ccaa,Long>,  QueryByCriteria<Ccaa, GeneralCriteria> {

    @Query(value = "SELECT c FROM Ccaa c")
    Page<Ccaa> findAllByCriteria(GeneralCriteria criteria, Pageable pageable);

    @Query(value="SELECT c FROM Ccaa c WHERE c.enrollment!='AND'")
    List<Ccaa> getAllCcaaAvaliable();

    @Query(value = "SELECT c FROM Ccaa c")
    List<Ccaa> findAll(GeneralCriteria criteria);



}
