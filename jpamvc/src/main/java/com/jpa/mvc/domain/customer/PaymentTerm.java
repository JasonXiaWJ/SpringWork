package com.jpa.mvc.domain.customer;

import static com.jpa.mvc.util.ItmsConstant.MEDIUM_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.TEXT_FIELD_SIZE;

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
public class PaymentTerm extends IdEntity {
    /**
     * 
     */
    private static final long serialVersionUID = -34681234074950876L;

    @Size(max = MEDIUM_FIELD_SIZE)
    @NotEmpty
    @Column(unique = true)
    private String condition;

    @Size(max = TEXT_FIELD_SIZE)
    private String description;
}
