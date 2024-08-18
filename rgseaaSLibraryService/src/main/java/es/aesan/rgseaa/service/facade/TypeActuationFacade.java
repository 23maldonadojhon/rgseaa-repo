package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.TypeActuationConverter;
import es.aesan.rgseaa.model.criteria.ActuationCriteria;
import es.aesan.rgseaa.model.criteria.CompanyActuationCriteria;
import es.aesan.rgseaa.model.dto.TypeActuationDto;
import es.aesan.rgseaa.model.entity.CompanyActuation;
import es.aesan.rgseaa.model.entity.TypeActuation;
import es.aesan.rgseaa.service.service.CompanyActuationService;
import es.aesan.rgseaa.service.service.TypeActuationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TypeActuationFacade extends AbstractFacade<
        TypeActuationDto,
        ActuationCriteria> {

    private final TypeActuationService typeActuationService;
    private final CompanyActuationService companyActuationService;

    private final TypeActuationConverter converter;


    @Override
    public TypeActuationDto get(Long id) {
        TypeActuation typeActuation = typeActuationService.get(id);
        TypeActuationDto dto = converter.entityToDto(typeActuation);
        return dto;
    }

    @Override
    public void add(TypeActuationDto dto){
        TypeActuation typeActuation=converter.dtoToEntity(dto);
        typeActuationService.add(typeActuation);
    }


    @Override
    public List<TypeActuationDto> list(ActuationCriteria criteria) {
        Collection<TypeActuation> list = typeActuationService.list(criteria);
        List<TypeActuationDto> dtoList = converter.mapEntityToDtoList(new ArrayList<>(list));
        return dtoList;
    }

    @Override
    public Page<TypeActuationDto> page(ActuationCriteria criteria){
        Page<TypeActuation> list= typeActuationService.page(criteria);
        Page<TypeActuationDto> dtoList=converter.mapEntityToDtoPage(list);
        return dtoList;
    }

    public List<TypeActuationDto> listCompany(ActuationCriteria criteria) {

        CompanyActuationCriteria companyActuationCriteria = new CompanyActuationCriteria();

        if(criteria.getEstablishmentId()>0)
            companyActuationCriteria.setEstablishmentId(criteria.getEstablishmentId());
        else
            companyActuationCriteria.setCompanyId(criteria.getCompanyId());


        Collection<CompanyActuation> companyActuationCollection = companyActuationService.list(companyActuationCriteria);
        List<TypeActuation> typeActuationList =  companyActuationCollection.stream().map(CompanyActuation::getActuation).collect(Collectors.toList());
        List<TypeActuationDto> typeActuationDtoList = converter.mapEntityToDtoList(typeActuationList);
        return typeActuationDtoList;
    }
}
