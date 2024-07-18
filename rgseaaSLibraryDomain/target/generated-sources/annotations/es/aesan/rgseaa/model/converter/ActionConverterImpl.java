package es.aesan.rgseaa.model.converter;

import es.aesan.rgseaa.model.dto.ActionDto;
import es.aesan.rgseaa.model.dto.TypeActionDto;
import es.aesan.rgseaa.model.entity.Action;
import es.aesan.rgseaa.model.entity.TypeAction;
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
public class ActionConverterImpl implements ActionConverter {

    @Override
    public Action dtoToEntity(ActionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Action action = new Action();

        action.setId( dto.getId() );
        action.setDescription( dto.getDescription() );
        action.setTypeAction( typeActionDtoToTypeAction( dto.getTypeAction() ) );

        return action;
    }

    @Override
    public ActionDto entityToDto(Action entity) {
        if ( entity == null ) {
            return null;
        }

        ActionDto actionDto = new ActionDto();

        actionDto.setId( entity.getId() );
        actionDto.setDescription( entity.getDescription() );
        actionDto.setTypeAction( typeActionToTypeActionDto( entity.getTypeAction() ) );

        return actionDto;
    }

    @Override
    public List<ActionDto> mapEntityToDtoList(List<Action> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ActionDto> list = new ArrayList<ActionDto>( entityList.size() );
        for ( Action action : entityList ) {
            list.add( entityToDto( action ) );
        }

        return list;
    }

    @Override
    public List<Action> mapDtoToEntityList(List<ActionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Action> list = new ArrayList<Action>( dtoList.size() );
        for ( ActionDto actionDto : dtoList ) {
            list.add( dtoToEntity( actionDto ) );
        }

        return list;
    }

    protected TypeAction typeActionDtoToTypeAction(TypeActionDto typeActionDto) {
        if ( typeActionDto == null ) {
            return null;
        }

        TypeAction typeAction = new TypeAction();

        typeAction.setId( typeActionDto.getId() );
        typeAction.setName( typeActionDto.getName() );
        typeAction.setNoDelete( typeActionDto.getNoDelete() );
        typeAction.setVisibleCcaa( typeActionDto.getVisibleCcaa() );

        return typeAction;
    }

    protected TypeActionDto typeActionToTypeActionDto(TypeAction typeAction) {
        if ( typeAction == null ) {
            return null;
        }

        TypeActionDto typeActionDto = new TypeActionDto();

        typeActionDto.setId( typeAction.getId() );
        typeActionDto.setName( typeAction.getName() );
        typeActionDto.setNoDelete( typeAction.getNoDelete() );
        typeActionDto.setVisibleCcaa( typeAction.getVisibleCcaa() );

        return typeActionDto;
    }
}
