package com.jpa.mvc.domain;

import static com.jpa.mvc.util.ItmsConstant.MEDIUM_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.NORMAL_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.SHORT_PLUS_FIELD_SIZE;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;

@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class Contact implements Serializable {
    private static final long serialVersionUID = 5011928109344001439L;

    @NotNull
    @Size(max = MEDIUM_FIELD_SIZE)
    private String contactName;

    @NotNull
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    private String contactPhone;

    @NotNull
    @Email
    @Size(max = NORMAL_FIELD_SIZE)
    private String contactEmail;
}
