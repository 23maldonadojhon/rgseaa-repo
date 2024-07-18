package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.ModuleCriteria;
import es.aesan.rgseaa.model.entity.Module;
import es.aesan.rgseaa.service.repository.ModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class ModuleService extends AbstractService<Module,Long,ModuleRepository, ModuleCriteria> {

    ModuleService(ModuleRepository repository){
        super(repository);
    }

}
