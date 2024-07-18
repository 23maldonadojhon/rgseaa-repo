package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.FormPresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormPresentationRepository
        extends BaseRepository<FormPresentation,Long>,
        QueryByCriteria<FormPresentation, GeneralCriteria> {

    @Query(value = "SELECT f FROM FormPresentation f")
    Page<FormPresentation> findAllByCriteria(@Param("criteria") GeneralCriteria criteria, Pageable pageable);
}
