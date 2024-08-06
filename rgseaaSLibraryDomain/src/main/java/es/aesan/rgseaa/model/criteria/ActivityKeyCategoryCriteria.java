package es.aesan.rgseaa.model.criteria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class ActivityKeyCategoryCriteria extends GeneralCriteria {
    private Long activityKeyId;
    private Long categoryId;
    private Long activityId;
    private Long keyId;
}
