package es.aesan.rgseaa.rest.controller;

import es.aesan.rgseaa.model.commom.criteria.FilterCriteria;
import es.aesan.rgseaa.model.commom.dto.StatusChange;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CrudController<
        D,
        C extends FilterCriteria> {

    ResponseEntity<Void> add(final @RequestBody D dto);
    ResponseEntity<Void> update(final @RequestBody D dto);
    ResponseEntity<D> get(final @PathVariable Long id);
    ResponseEntity<D> find(C criteria);
    ResponseEntity<List<D>> list(C criteria);
    ResponseEntity<Page<D>> page(C criteria);
}
