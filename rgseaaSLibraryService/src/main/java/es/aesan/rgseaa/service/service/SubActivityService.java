package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.SubActivity;
import es.aesan.rgseaa.service.repository.SubActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SubActivityService
    extends AbstractService<SubActivity, Long, SubActivityRepository, GeneralCriteria> {


    SubActivityService(SubActivityRepository repository) {
        super(repository);
    }

    public List<SubActivity> findById(Collection<Long> list){
        logger.info("==== findByActivity ");

        List<SubActivity> resultList = repository.findById(list);

        return resultList;
    }

}
