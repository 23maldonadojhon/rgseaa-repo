package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CrudFacade<D,C extends FilterCriteria> {

    void add(final D dto);

    void update(final D dto);

    D get(final Long id);

    D find(final C criteria);

    List<D> list(final C dto);

    Page<D> page(final C dto);

}
