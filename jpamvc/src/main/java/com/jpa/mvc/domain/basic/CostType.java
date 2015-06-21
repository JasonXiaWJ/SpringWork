package com.jpa.mvc.domain.basic;

import static com.jpa.mvc.util.ItmsConstant.SHORT_PLUS_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.MEDIUM_FIELD_SIZE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import com.jpa.mvc.domain.IdEntity;

@Entity
@Setter
@Getter
public class CostType extends IdEntity {
    private static final long serialVersionUID = -8885163151750783790L;

    @Column(unique = true)
    @NotEmpty
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    private String sapCode;

    @Column(unique = true)
    @NotEmpty
    @Size(max = MEDIUM_FIELD_SIZE)
    private String type;
}
