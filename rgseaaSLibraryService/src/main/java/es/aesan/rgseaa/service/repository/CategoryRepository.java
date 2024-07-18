package es.aesan.rgseaa.service.repository;

import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoryRepository
        extends BaseRepository<Category,Long>,
        QueryByCriteria<Category, CategoryCriteria> {

    @Query(value = "SELECT c FROM Category c")
    Page<Category> findAllByCriteria(CategoryCriteria criteria, Pageable pageable);

    @Query(value = "SELECT c FROM Category c WHERE c.id IN :list")
    List<Category> findById(@Param("list") List<Long> list);
}
