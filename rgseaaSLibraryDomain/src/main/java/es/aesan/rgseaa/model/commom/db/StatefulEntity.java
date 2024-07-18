package es.aesan.rgseaa.model.commom.db;

/**
 * Allows the implementation of soft-delete entities using a state
 */
public interface StatefulEntity {
    Integer getState();

    void setState(Integer state);
}
