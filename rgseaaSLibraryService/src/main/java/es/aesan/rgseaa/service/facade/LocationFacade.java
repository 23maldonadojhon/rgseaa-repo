package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.LocationConverter;
import es.aesan.rgseaa.model.criteria.LocationCriteria;
import es.aesan.rgseaa.model.dto.LocationDto;
import es.aesan.rgseaa.model.entity.Location;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.service.service.LocationService;
import es.aesan.rgseaa.service.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationFacade extends AbstractFacade<
        LocationDto,
        LocationCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(LocationFacade.class);

    private final ProvinceService provinceService;
    private final LocationService locationService;

    private final LocationConverter locationConverter;


    @Override
    public List<LocationDto> list(LocationCriteria criteria) {
        logger.info("==== FACADE-> LOCATION LIST ====");

        List<LocationDto> result = null;

        if(criteria.getProvinceId()!=null){

            Province province = provinceService.get(criteria.getProvinceId());

            LocationCriteria locationCriteria = new LocationCriteria();
            locationCriteria.setEnrollmentProvince(province.getEnrollment());

            Collection<Location> entitieList = locationService.list(locationCriteria);

            result = locationConverter.mapEntityToDtoList(new ArrayList<>(entitieList));
        }

        return result;
    }
}
