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
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryKeyActivityCategoryCriteria extends FilterCriteria {
    private Long idIndustry;
    private Long idKey;
    private Long idCategory;
    private String codeActivity;
}
