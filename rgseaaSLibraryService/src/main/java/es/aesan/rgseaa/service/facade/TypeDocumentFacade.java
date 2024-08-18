package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.TypeDocumentConverter;
import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.model.entity.TypeDocument;
import es.aesan.rgseaa.service.service.TypeDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TypeDocumentFacade extends AbstractFacade<
        TypeDocumentDto,
        GeneralCriteria> {

    private final TypeDocumentService typeDocumentService;

    private final TypeDocumentConverter converter;

    @Override
    public void add(TypeDocumentDto dto){
        TypeDocument typeDocument=converter.dtoToEntity(dto);
        typeDocumentService.add(typeDocument);
    }

    @Override
    public void update(TypeDocumentDto dto){
        TypeDocument typeDocument= converter.dtoToEntity(dto);
        typeDocumentService.update(typeDocument);
    }

    @Override
    public List<TypeDocumentDto> list(GeneralCriteria criteria) {
        Collection<TypeDocument> list = typeDocumentService.list(criteria);
        List<TypeDocumentDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }

    @Override
    public Page<TypeDocumentDto> page(GeneralCriteria criteria){
        Page<TypeDocument> page= typeDocumentService.page(criteria);
        Page<TypeDocumentDto> dtoPage=converter.mapEntityToDtoPage(page);
        return dtoPage;
    }
@Override
    public TypeDocumentDto get(Long id) {
    TypeDocument typeDocument = typeDocumentService.get(id);
    TypeDocumentDto typeDocumentDto = converter.entityToDto(typeDocumentService.get(id));
    return  typeDocumentDto;
}
}
