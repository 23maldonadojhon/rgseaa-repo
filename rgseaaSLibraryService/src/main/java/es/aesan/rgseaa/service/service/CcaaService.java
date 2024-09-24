package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Ccaa;
import es.aesan.rgseaa.service.repository.CcaaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CcaaService extends AbstractService<
        Ccaa,
        Long,
        CcaaRepository,
        GeneralCriteria> {

    CcaaService(CcaaRepository repository) {
        super(repository);
    }

    public Page<Ccaa> getAllCcaaAvaliable(){
        List<Ccaa> ccaaList=repository.getAllCcaaAvaliable();
        Page<Ccaa> ccaaPage= new PageImpl<>(ccaaList);
        return ccaaPage;
    }
}
