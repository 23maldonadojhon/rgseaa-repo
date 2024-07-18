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
public class ProductCriteria extends FilterCriteria  {
    private Long industryId;
    private String brand;
    private String numProduct;
    private String numRegister;
    private String ingredientKey26;
    private Long situationSearch;
    private Long competentAuthoritySearch;
}
