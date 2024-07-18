package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.entity.TypeAction;
import es.aesan.rgseaa.service.repository.TypeActionRepository;
import org.springframework.stereotype.Service;


@Service
public class TypeActionService
        extends AbstractService<TypeAction, Long, TypeActionRepository, FilterCriteria> {

    TypeActionService(TypeActionRepository repository) {
        super(repository);
    }

}
