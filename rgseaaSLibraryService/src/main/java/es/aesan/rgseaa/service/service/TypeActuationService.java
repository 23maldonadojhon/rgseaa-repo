package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.TypeActuation;

import es.aesan.rgseaa.service.repository.TypeActuationRepository;
import es.aesan.rgseaa.service.repository.TypeDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeActuationService
        extends AbstractService<TypeActuation,Long, TypeActuationRepository,GeneralCriteria> {

    TypeActuationService(TypeActuationRepository repository){
        super(repository);
    }

}