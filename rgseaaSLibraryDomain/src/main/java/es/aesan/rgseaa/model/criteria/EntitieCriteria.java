package es.aesan.rgseaa.model.criteria;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class EntitieCriteria extends FilterCriteria {

    private String name;
    private String description;
    private String code;
    private String postalCode;
    private String address;
    private String contactPerson;
    private String phone;
    private String email;
    private boolean rootEntity;
    private Integer parent;
    private String entityType;
    private String typeName;

}
