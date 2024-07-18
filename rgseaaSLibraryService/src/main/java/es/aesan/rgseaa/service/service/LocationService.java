package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.entity.Location;
import es.aesan.rgseaa.service.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService
    extends AbstractService<Location,Long, LocationRepository, GeneralCriteria> {

    LocationService(LocationRepository repository) {
        super(repository);
    }

}
