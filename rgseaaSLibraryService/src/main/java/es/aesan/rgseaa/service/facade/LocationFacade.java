package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.LocationConverter;
import es.aesan.rgseaa.model.criteria.LocationCriteria;
import es.aesan.rgseaa.model.dto.LocationDto;
import es.aesan.rgseaa.model.entity.Location;
import es.aesan.rgseaa.model.entity.Province;
import es.aesan.rgseaa.service.service.LocationService;
import es.aesan.rgseaa.service.service.ProvinceService;
import es.aesan.rgseaa.service.util.Accion;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void add(LocationDto dto){
        logger.info("-----Facade -> ADD LOCATION---");
        logger.info("Location:"+dto);

      //  valid(dto, Accion.ADD);

        Location location=locationConverter.dtoToEntity(dto);
        locationService.add(location);


    }


    @Override
    public List<LocationDto> list(LocationCriteria criteria) {
        logger.info("==== FACADE-> LOCATION LIST ====");

        Collection<Location> locationCollection = locationService.list(criteria);
        List<LocationDto> locationDtos=locationConverter.mapEntityToDtoList(new ArrayList<>(locationCollection));
        return  locationDtos;



//        List<LocationDto> result = null;
//
//        if(criteria.getProvinceId()!=null){
//
//            Province province = provinceService.get(criteria.getProvinceId());
//
//            LocationCriteria locationCriteria = new LocationCriteria();
//            locationCriteria.setEnrollmentProvince(province.getEnrollment());
//
//            Collection<Location> entitieList = locationService.list(locationCriteria);
//
//            result = locationConverter.mapEntityToDtoList(new ArrayList<>(entitieList));
//        }
//
//        return result;
    }

    @Override
    public LocationDto get(final Long id ){
        logger.info("---- Facade -> Find By Location");
        logger.info("id :" +id);

        Location location= locationService.get(id);
        LocationDto locationDto= locationConverter.entityToDto(locationService.get(id));
        return locationDto;


    }
    @Override
    public Page<LocationDto> page(LocationCriteria criteria){
        logger.info("----- FACADE -> LOCATION CRITERIA ----");
        logger.info("critera: "+criteria);
        Page<Location> locationPage=locationService.page(criteria);
        Page<LocationDto> locationDtos=locationConverter.mapEntityToDtoPage(locationPage);
        return  locationDtos;

    }
}
