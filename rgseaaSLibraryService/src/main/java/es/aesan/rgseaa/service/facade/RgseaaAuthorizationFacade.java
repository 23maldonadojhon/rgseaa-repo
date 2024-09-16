package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.converter.RgseaaAuthorizationConverter;
import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaAuthorizationCriteria;
import es.aesan.rgseaa.model.dto.RgseaaAuthorizationDto;
import es.aesan.rgseaa.model.entity.RgseaaAuthorization;
import es.aesan.rgseaa.service.service.RgseaaAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RgseaaAuthorizationFacade extends AbstractFacade<
    RgseaaAuthorizationDto,
    RgseaaAuthorizationCriteria> {


    private static final Logger logger = LoggerFactory.getLogger(RgseaaAuthorizationFacade.class);

    private final RgseaaAuthorizationService rgseaaAuthorizationService;
    private final RgseaaAuthorizationConverter rgseaaAuthorizationConverter;

    @Override
    public List<RgseaaAuthorizationDto> list(RgseaaAuthorizationCriteria criteria) {
        logger.info("==== FACADE-> LIST RGSEAA_AUTHORIZATION====");

        Collection<RgseaaAuthorization> rgseaaAuthorizationList = rgseaaAuthorizationService.list(criteria);
        List<RgseaaAuthorizationDto> rgseaaAuthorizationDto = rgseaaAuthorizationConverter.mapEntityToDtoList(new ArrayList<>(rgseaaAuthorizationList));
        return rgseaaAuthorizationDto;
    }

}
