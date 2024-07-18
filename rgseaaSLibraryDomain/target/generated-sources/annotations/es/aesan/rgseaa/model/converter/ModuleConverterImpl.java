package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ModuleDto;
import es.aesan.rgseaa.model.dto.ModuleTypeDto;
import es.aesan.rgseaa.model.entity.Module;
import es.aesan.rgseaa.model.entity.ModuleType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T08:06:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ModuleConverterImpl implements ModuleConverter {

    @Override
    public Module dtoToEntity(ModuleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Module module = new Module();

        module.setState( dto.getState() );
        module.setId( dto.getId() );
        module.setName( dto.getName() );
        module.setDescription( dto.getDescription() );
        module.setCode( dto.getCode() );
        module.setType( moduleTypeDtoToModuleType( dto.getType() ) );

        return module;
    }

    @Override
    public List<ModuleDto> mapEntityToDtoList(List<Module> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ModuleDto> list = new ArrayList<ModuleDto>( entityList.size() );
        for ( Module module : entityList ) {
            list.add( entityToDto( module ) );
        }

        return list;
    }

    @Override
    public List<Module> mapDtoToEntityList(List<ModuleDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Module> list = new ArrayList<Module>( dtoList.size() );
        for ( ModuleDto moduleDto : dtoList ) {
            list.add( dtoToEntity( moduleDto ) );
        }

        return list;
    }

    @Override
    public ModuleDto entityToDto(Module item) {
        if ( item == null ) {
            return null;
        }

        ModuleDto moduleDto = new ModuleDto();

        moduleDto.setId( item.getId() );
        moduleDto.setState( item.getState() );
        moduleDto.setName( item.getName() );
        moduleDto.setDescription( item.getDescription() );
        moduleDto.setCode( item.getCode() );
        moduleDto.setType( moduleTypeToModuleTypeDto( item.getType() ) );

        return moduleDto;
    }

    protected ModuleType moduleTypeDtoToModuleType(ModuleTypeDto moduleTypeDto) {
        if ( moduleTypeDto == null ) {
            return null;
        }

        ModuleType moduleType = new ModuleType();

        moduleType.setState( moduleTypeDto.getState() );
        moduleType.setId( moduleTypeDto.getId() );
        moduleType.setName( moduleTypeDto.getName() );
        moduleType.setDescription( moduleTypeDto.getDescription() );

        return moduleType;
    }

    protected ModuleTypeDto moduleTypeToModuleTypeDto(ModuleType moduleType) {
        if ( moduleType == null ) {
            return null;
        }

        ModuleTypeDto moduleTypeDto = new ModuleTypeDto();

        moduleTypeDto.setId( moduleType.getId() );
        moduleTypeDto.setState( moduleType.getState() );
        moduleTypeDto.setName( moduleType.getName() );
        moduleTypeDto.setDescription( moduleType.getDescription() );

        return moduleTypeDto;
    }
}
