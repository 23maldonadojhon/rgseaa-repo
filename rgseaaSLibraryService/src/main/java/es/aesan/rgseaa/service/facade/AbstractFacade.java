package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.commom.dto.StatusChange;
import org.springframework.data.domain.Page;

import java.util.List;

public abstract class AbstractFacade<
        D,
        C extends FilterCriteria
        > implements CrudFacade<D,C> {

    @Override
    public void add(D dto) {}

    @Override
    public void update(D dto) {}

    @Override
    public D get(Long id) {
        return null;
    }

    @Override
    public D find(C criteria) {
        return null;
    }

    @Override
    public List<D> list(C criteria) {
        return null;
    }

    @Override
    public Page<D> page(C criteria) {
        return null;
    }


}
