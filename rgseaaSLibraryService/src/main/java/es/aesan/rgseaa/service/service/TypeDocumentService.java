package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.criteria.TypeDocumentCriteria;
import es.aesan.rgseaa.model.entity.TypeDocument;
import es.aesan.rgseaa.service.repository.TypeDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeDocumentService extends AbstractService<
        TypeDocument,
        Long,
        TypeDocumentRepository,
        TypeDocumentCriteria> {

    TypeDocumentService(TypeDocumentRepository repository){
        super(repository);
    }

}
