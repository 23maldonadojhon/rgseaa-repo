package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.entity.EntitieType;
import es.aesan.rgseaa.service.repository.EntitieTypeRepository;
import org.springframework.stereotype.Service;


@Service
public class EntitieTypeService extends AbstractService<EntitieType,Long,EntitieTypeRepository, FilterCriteria> {

    EntitieTypeService(EntitieTypeRepository repository){
        super(repository);
    }

}
