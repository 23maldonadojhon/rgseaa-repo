package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.DocumentCriteria;
import es.aesan.rgseaa.model.entity.Document;
import es.aesan.rgseaa.service.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DocumentService extends AbstractService<Document,Long,DocumentRepository,DocumentCriteria> {

    DocumentService(DocumentRepository repository){
        super(repository);
    }

    public List<Document> all(DocumentCriteria criteria){

        logger.info("==== ALL Document ====");
        logger.info("entity :"+criteria.toString());

        List<Document> documentList = repository.findAll(criteria);

        return documentList;
    }

}
