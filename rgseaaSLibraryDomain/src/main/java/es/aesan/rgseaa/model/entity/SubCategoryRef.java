package es.aesan.rgseaa.model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class SubCategoryRef {
    private Long id;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}