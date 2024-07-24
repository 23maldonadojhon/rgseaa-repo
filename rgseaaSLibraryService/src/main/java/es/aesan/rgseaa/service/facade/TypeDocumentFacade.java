package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.TypeDocumentConverter;
import es.aesan.rgseaa.model.dto.TypeDocumentDto;
import es.aesan.rgseaa.model.entity.TypeDocument;
import es.aesan.rgseaa.service.service.TypeDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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
    public Page<TypeDocumentDto> page(GeneralCriteria criteria){
        Page<TypeDocument> list= typeDocumentService.page(criteria);
        Page<TypeDocumentDto> dtoList=converter.mapEntityToDtoPage(list);
        return dtoList;
    }
}
