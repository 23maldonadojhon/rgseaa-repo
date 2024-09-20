package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.criteria.ActionCriteria;
import es.aesan.rgseaa.model.entity.Action;
import es.aesan.rgseaa.service.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActionService
        extends AbstractService<Action,Long,ActionRepository, FilterCriteria> {

    ActionService(ActionRepository repository) {
        super(repository);
    }

    public List<Action> all(ActionCriteria criteria){

        logger.info("==== ALL Action ====");
        logger.info("entity :"+criteria.toString());

        List<Action> documentList = repository.findAll(criteria);

        return documentList;
    }

}
