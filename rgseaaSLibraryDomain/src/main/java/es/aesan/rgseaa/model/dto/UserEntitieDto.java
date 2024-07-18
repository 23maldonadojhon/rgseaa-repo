package es.aesan.rgseaa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntitieDto {

    private Long user;
    private Long entity;
    private String scopeCode;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String entityCode;
    private String entityName;
    private Long entityParentId;
    private Long languageId;
    private String languageIsoCode;
    private String languageName;
}
