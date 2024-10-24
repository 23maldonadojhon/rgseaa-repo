package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.RgseaaConverter;
import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.dto.RgseaaDto;
import es.aesan.rgseaa.model.entity.Rgseaa;
import es.aesan.rgseaa.service.service.RgseaaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RgseaaFacade extends AbstractFacade<
        RgseaaDto,
        RgseaaCriteria
        > {

    private static final Logger logger = LoggerFactory.getLogger(RgseaaFacade.class);

    private final RgseaaService rgseaaService;

    private final RgseaaConverter rgseaaConverter;

    @Override
    public RgseaaDto get(Long id) {
        Rgseaa rgseaa = rgseaaService.get(id);
        RgseaaDto rgseaaDto = rgseaaConverter.entityToDto(rgseaa);
        return rgseaaDto;
    }

    @Override
    public List<RgseaaDto> list(RgseaaCriteria criteria) {

        RgseaaCriteria rgseaaCriteria = new RgseaaCriteria();

        if(criteria.getEstablishmentId()>0)
            rgseaaCriteria.setEstablishmentId(criteria.getEstablishmentId());
        else
            rgseaaCriteria.setCompanyId(criteria.getCompanyId());

        Collection<Rgseaa> rgseaaCollection = rgseaaService.list(rgseaaCriteria);
        List<RgseaaDto> rgseaaDtoList = rgseaaConverter.mapEntityToDtoList(new ArrayList<>(rgseaaCollection));
        return rgseaaDtoList;
    }

}
