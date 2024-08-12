package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.ActivityConverter;
import es.aesan.rgseaa.model.converter.CategoryConverter;
import es.aesan.rgseaa.model.converter.KeyConverter;
import es.aesan.rgseaa.model.converter.SubActivityConverter;
import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.criteria.RgseaaCriteria;
import es.aesan.rgseaa.model.dto.KeyDto;
import es.aesan.rgseaa.model.dto.RgseaaActivityDto;
import es.aesan.rgseaa.model.entity.Rgseaa;
import es.aesan.rgseaa.model.entity.RgseaaActivity;
import es.aesan.rgseaa.service.service.RgseaaActivityService;
import es.aesan.rgseaa.service.service.RgseaaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
@RequiredArgsConstructor
public class RgseaaActivityFacade extends AbstractFacade<
        RgseaaActivityDto,
        RgseaaActivityCriteria> {


    private final RgseaaActivityService rgseaaActivityService;
    private final RgseaaService rgseaaService;

    private final KeyConverter keyConverter;
    private final ActivityConverter activityConverter;
    private final CategoryConverter categoryConverter;
    private final SubActivityConverter subActivityConverter;

    private static final Logger logger = LoggerFactory.getLogger(RgseaaActivityFacade.class);



    @Override
    public List<RgseaaActivityDto> list(RgseaaActivityCriteria criteria) {

        List<RgseaaActivityDto> dtos = new ArrayList<>();

        Rgseaa rgseaa = rgseaaService.get(criteria.getRgseaaId());

        KeyDto keyDto = keyConverter.entityToDto(rgseaa.getKey());

        criteria.setRgseaaId(rgseaa.getId());
        Collection<RgseaaActivity> rgseaaActivityList = rgseaaActivityService.list(criteria);

        rgseaaActivityList.forEach(item->{
            RgseaaActivityDto dto = new RgseaaActivityDto();
            dto.setKey(keyDto);
            dto.setActivity(activityConverter.entityToDto(item.getActivity()));
            dto.setCategory(categoryConverter.entityToDto(item.getCategory()));
            dto.setSubActivity(subActivityConverter.entityToDto(item.getSubActivity()));

            dtos.add(dto);
        });

        return dtos;
    }
}
