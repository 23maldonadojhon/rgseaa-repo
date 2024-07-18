package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.KeyActivityCategoryCriteria;
import es.aesan.rgseaa.model.entity.KeyActivityCategory;
import es.aesan.rgseaa.service.repository.KeyActivityCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyActivityCategoryService {

    protected static final Logger logger = LoggerFactory.getLogger(KeyActivityCategoryService.class);

    @Autowired
    private KeyActivityCategoryRepository repository;


    public List<KeyActivityCategory> list(KeyActivityCategoryCriteria criteria){
        logger.info("==== KeyActivityCategoryService list ====");
        logger.info("criteria="+criteria);

        List<KeyActivityCategory> list = repository.findAllCriteria(criteria);
        return list;
    }
}
