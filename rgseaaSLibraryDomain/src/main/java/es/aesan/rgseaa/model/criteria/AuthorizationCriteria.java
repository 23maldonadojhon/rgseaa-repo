package es.aesan.rgseaa.model.criteria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationCriteria extends FilterCriteria {
    private Long companyId;
}
