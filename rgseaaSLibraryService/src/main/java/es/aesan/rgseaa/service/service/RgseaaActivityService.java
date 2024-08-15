package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.entity.RgseaaActivity;
import es.aesan.rgseaa.service.repository.RgseaaActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class RgseaaActivityService extends AbstractService<
        RgseaaActivity,
        Long,
        RgseaaActivityRepository,
        RgseaaActivityCriteria
        > {

    RgseaaActivityService(RgseaaActivityRepository repository) {
        super(repository);
    }
}
