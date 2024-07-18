package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.EntitieCriteria;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.service.repository.EntitieRepository;
import org.springframework.stereotype.Service;


@Service
public class EntitieService extends AbstractService<Entitie,Long,EntitieRepository,EntitieCriteria> {

    EntitieService(EntitieRepository repository){
        super(repository);
    }

}
