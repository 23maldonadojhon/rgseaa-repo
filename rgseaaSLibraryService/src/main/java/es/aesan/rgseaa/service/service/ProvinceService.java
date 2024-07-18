package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.service.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService
        extends AbstractService<Province,Long, ProvinceRepository, GeneralCriteria> {

    ProvinceService(ProvinceRepository repository) {
        super(repository);
    }

}
