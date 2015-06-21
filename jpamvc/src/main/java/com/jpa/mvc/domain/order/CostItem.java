package com.jpa.mvc.domain.order;

import static com.jpa.mvc.util.ItmsConstant.AMOUNT_FRACTION;
import static com.jpa.mvc.util.ItmsConstant.AMOUNT_INTEGER;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.jpa.mvc.domain.basic.CostType;

@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class CostItem implements Serializable {
    private static final long serialVersionUID = -1382817734185615255L;

    // the value is UUID
    @NotNull
    private String costTypeKey;

    @NotNull
    @ManyToOne
    private CostType costType;

    @NotNull
    @Digits(integer = AMOUNT_INTEGER, fraction = AMOUNT_FRACTION)
    private double amount;

    public CostItem(CostType costType, double amount) {
        super();
        this.costTypeKey = UUID.randomUUID().toString();
        this.costType = costType;
        this.amount = amount;
    }

    @Deprecated
    /**
     * just use by test case
     */
    public CostItem() {
        super();
        this.costTypeKey = UUID.randomUUID().toString();
    }

}