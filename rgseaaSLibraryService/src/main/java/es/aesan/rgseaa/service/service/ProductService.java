package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.ProductCriteria;
import es.aesan.rgseaa.model.entity.Product;
import es.aesan.rgseaa.service.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService
        extends AbstractService<Product, Long, ProductRepository, ProductCriteria> {


    ProductService(ProductRepository productRepository){
        super(productRepository);
    }

    public boolean getByBrandExist(String brand){
        logger.info("==== getByBrand ====");
        logger.info("brand :"+brand);

        boolean response = false;

        Product product = repository.findByBrandExists(brand);

        if(product!=null)
            response = true;

        return response;
    }

}
