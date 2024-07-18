package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.criteria.ModuleCriteria;
import es.aesan.rgseaa.model.converter.ModuleConverter;
import es.aesan.rgseaa.model.dto.ModuleDto;
import es.aesan.rgseaa.model.entity.Module;
import es.aesan.rgseaa.service.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModuleFacade {

    @Autowired
    private final ModuleConverter moduleConverter;

    @Autowired
    private final ModuleService moduleService;

    private static final Logger logger = LoggerFactory.getLogger(ModuleFacade.class);

    public Page<ModuleDto> moduleAll(ModuleCriteria criteria){

        Page<Module> page = moduleService.page(criteria);

        Page<ModuleDto> dtoPage = moduleConverter.mapEntityToDtoPage(page);

        return  dtoPage;
    }

}
