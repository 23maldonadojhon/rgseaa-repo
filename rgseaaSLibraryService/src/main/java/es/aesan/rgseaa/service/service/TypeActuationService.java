package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.TypeActuationCriteria;
import es.aesan.rgseaa.model.entity.TypeActuation;
import es.aesan.rgseaa.service.repository.TypeActuationRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeActuationService
        extends AbstractService<TypeActuation,Long, TypeActuationRepository, TypeActuationCriteria> {

    TypeActuationService(TypeActuationRepository repository){
        super(repository);
    }

}
