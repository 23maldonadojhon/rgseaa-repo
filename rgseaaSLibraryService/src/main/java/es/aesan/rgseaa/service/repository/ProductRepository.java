package es.aesan.rgseaa.service.repository;


import es.aesan.rgseaa.model.criteria.ProductCriteria;
import es.aesan.rgseaa.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product,Long>,
        QueryByCriteria<Product, ProductCriteria>  {


    @Query(value = " SELECT p FROM Product p " +
            " WHERE " +
            " (:#{#criteria.brand} IS NULL OR UPPER(p.brand) LIKE UPPER(:#{#criteria.brand})) "+
            " AND (:#{#criteria.industryId} IS NULL OR p.industryId = :#{#criteria.industryId}) "+
            " AND (:#{#criteria.numProduct} IS NULL OR p.numProduct LIKE :#{#criteria.numProduct}) "+
            " AND (:#{#criteria.numRegister} IS NULL OR p.numRegister LIKE :#{#criteria.numRegister}) "+
            " AND (:#{#criteria.ingredientKey26} IS NULL OR p.ingredientKey26 LIKE :#{#criteria.ingredientKey26}) "+
            " AND (:#{#criteria.situationSearch} IS NULL OR p.situation.id = :#{#criteria.situationSearch}) "+
            " AND (:#{#criteria.competentAuthoritySearch} IS NULL OR p.competentAuthority.id = :#{#criteria.competentAuthoritySearch}) "+
            " AND (" +
            "  :#{#criteria.search} IS NULL OR UPPER(p.brand) LIKE UPPER(:#{#criteria.search}) "+
            " )"
    )
    Page<Product> findAllByCriteria(@Param("criteria") ProductCriteria criteria, Pageable pageable);


    @Query(value = "SELECT p FROM Product p WHERE UPPER(p.brand) = UPPER(:brand)")
    Product findByBrandExists(@Param("brand") String  brand);

}
