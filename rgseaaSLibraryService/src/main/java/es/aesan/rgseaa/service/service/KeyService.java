package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Key;
import es.aesan.rgseaa.service.repository.KeyRepository;
import org.springframework.stereotype.Service;


@Service
public class KeyService extends AbstractService<
        Key,
        Long,
        KeyRepository,
        GeneralCriteria> {

    KeyService(KeyRepository repository){
        super(repository);
    }

}
