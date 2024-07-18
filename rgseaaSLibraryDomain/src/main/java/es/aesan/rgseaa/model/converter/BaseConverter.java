package es.aesan.rgseaa.model.converter;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface BaseConverter<E,D> {

    E dtoToEntity(D dto);

    D entityToDto(E entity);

    List<D> mapEntityToDtoList(List<E> entityList);

    List<E> mapDtoToEntityList(List<D> dtoList);


    default Page<D> mapEntityToDtoPage(Page<E> page){
        List<D> content = mapEntityToDtoList(page.getContent());
        return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
    }
}
