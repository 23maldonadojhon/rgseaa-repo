package es.aesan.rgseaa.model.criteria;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubActivityCriteria extends FilterCriteria {
    private Long id;
    private String name;
    private Long activityId;
    private Long keyId;
    private Long categoryId;
}