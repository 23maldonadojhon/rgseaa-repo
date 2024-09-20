package es.aesan.rgseaa.model.criteria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyActuationCriteria  extends GeneralCriteria {
    private Long companyId;
    private Long establishmentId;
}

