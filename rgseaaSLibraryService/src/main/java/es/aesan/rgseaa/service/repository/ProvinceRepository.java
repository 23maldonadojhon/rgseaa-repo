package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceRepository
        extends BaseRepository<Province,Long>,
        QueryByCriteria<Province, GeneralCriteria> {

    @Override
    @Query(value = "SELECT p FROM Province p")
    Page<Province> findAllByCriteria(@Param("criteria") GeneralCriteria criteria, Pageable pageable);

    @Query(value = "SELECT p FROM Province p")
    List<Province> findAll(GeneralCriteria criteria);
}
