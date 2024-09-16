package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.DocumentConverter;
import es.aesan.rgseaa.model.criteria.DocumentCriteria;
import es.aesan.rgseaa.model.dto.B64EncodedFileDto;
import es.aesan.rgseaa.model.dto.DocumentDto;
import es.aesan.rgseaa.model.entity.Document;
import es.aesan.rgseaa.service.service.DocumentService;
import es.aesan.rgseaa.service.service.FileUtilService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DocumentFacade extends AbstractFacade<
        DocumentDto,
        DocumentCriteria
        > {

    private final DocumentService documentService;
    private final DocumentConverter documentConverter;

    private final FileUtilService fileUtilService;

    private static final Logger logger = LoggerFactory.getLogger(DocumentFacade.class);


    @Override
    public List<DocumentDto> list(DocumentCriteria criteria) {

        List<Document> documentList = documentService.all(criteria);
        List<DocumentDto> documentDtoList = getDocumentDtoList(documentList);

        return documentDtoList;
    }

    private List<DocumentDto> getDocumentDtoList(List<Document> documentList){
        logger.info("==== FACADE-> getDocumentDtoList ====");

        List<DocumentDto> documentDtoList = new ArrayList<>();

        for (Document document : documentList){
            DocumentDto documentDto = documentConverter.entityToDto(document);
            documentDto.setB64(getDocument(document));
            documentDtoList.add(documentDto);
        }

        return documentDtoList;
    }

    private B64EncodedFileDto getDocument(Document document){
        logger.info("==== FACADE-> getDocument ====");

        B64EncodedFileDto b64EncodedFileDto = new B64EncodedFileDto();
        b64EncodedFileDto.setData(fileUtilService.getFile(document.getPathFile()));
        b64EncodedFileDto.setName(fileUtilService.getNameFile(document.getPathFile()));
        return b64EncodedFileDto;
    }

}
