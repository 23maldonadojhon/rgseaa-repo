package es.aesan.rgseaa.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DocumentDto implements Serializable {
    Long id;
    String name;
    LocalDateTime date;
    TypeDocumentDto typeDocument;
    B64EncodedFileDto b64;
    Integer update;
}
