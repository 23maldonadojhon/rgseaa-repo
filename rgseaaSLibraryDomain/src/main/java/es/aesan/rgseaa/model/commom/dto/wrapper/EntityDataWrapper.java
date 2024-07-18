package es.aesan.rgseaa.model.commom.dto.wrapper;

import es.aesan.rgseaa.model.commom.db.BaseEntity;

public class EntityDataWrapper<T extends BaseEntity> extends RequestDataWrapper<T> {
    public EntityDataWrapper(T source) {
        super(source);
    }
}
