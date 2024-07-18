package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.DenominationSaleCriterial;
import es.aesan.rgseaa.model.entity.DenominationSale;
import es.aesan.rgseaa.service.repository.DenominationSaleRepository;
import org.springframework.stereotype.Service;


@Service
public class DenominationSaleService extends AbstractService<DenominationSale,Long,DenominationSaleRepository,DenominationSaleCriterial> {

    DenominationSaleService(DenominationSaleRepository repository){
        super(repository);
    }



}
