package com.jpa.mvc.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SelectOption {
    public SelectOption(Long id, String label) {
        super();
        this.id = id;
        this.label = label;
    }

    public SelectOption(String label) {
        this.label = label;
    }

    private Long id;
    private String label;
}
