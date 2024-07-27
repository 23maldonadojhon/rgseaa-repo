package es.aesan.rgseaa.service.facade;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.converter.SubActivityConverter;

import es.aesan.rgseaa.model.dto.SubActivityDto;

import es.aesan.rgseaa.model.entity.SubActivity;

import es.aesan.rgseaa.service.service.SubActivityService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubActivityFacade extends AbstractFacade<
        SubActivityDto,
        GeneralCriteria>  {

    private final SubActivityService subActivityService;

    private final SubActivityConverter converter;

    @Override
    public void add(SubActivityDto dto) {
        SubActivity subActivity = converter.dtoToEntity(dto);
        subActivityService.add(subActivity);
    }

    @Override
    public Page<SubActivityDto> page(GeneralCriteria criteria) {
        Page<SubActivity> list = subActivityService.page(criteria);
        Page<SubActivityDto> dtoList = converter.mapEntityToDtoPage(list);
        return dtoList;
    }
}
