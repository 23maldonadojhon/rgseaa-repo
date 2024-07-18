package es.aesan.rgseaa.model.commom.dto.wrapper;

import lombok.Data;

@Data
public class RequestDataWrapper<T> {
    private final T source;
}
