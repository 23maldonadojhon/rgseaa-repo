package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.FormPresentation;
import es.aesan.rgseaa.service.repository.FormPresentationRepository;
import org.springframework.stereotype.Service;

@Service
public class FormPresentationService
        extends AbstractService<FormPresentation,Long, FormPresentationRepository,GeneralCriteria> {

    FormPresentationService(FormPresentationRepository repository){
        super(repository);
    };

}
