package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.TypeActionCriteria;
import es.aesan.rgseaa.model.entity.TypeAction;
import es.aesan.rgseaa.service.repository.TypeActionRepository;
import org.springframework.stereotype.Service;


@Service
public class TypeActionService
        extends AbstractService<TypeAction, Long, TypeActionRepository, TypeActionCriteria> {

    TypeActionService(TypeActionRepository repository) {
        super(repository);
    }

}
