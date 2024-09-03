package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.CategoryCriteria;
import es.aesan.rgseaa.model.entity.Category;
import es.aesan.rgseaa.service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
    extends AbstractService<
        Category,
        Long,
        CategoryRepository,
        GeneralCriteria
        //CategoryCriteria


        > {

    CategoryService(CategoryRepository repository) {
        super(repository);
    }


    public List<Category> findById(List<Long> list){
        logger.info("==== findByActivity ");

        List<Category> resultList = repository.findById(list);

        return resultList;
    }
}
