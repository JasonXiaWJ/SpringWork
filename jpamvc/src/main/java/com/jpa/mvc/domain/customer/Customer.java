package com.jpa.mvc.domain.customer;

import static com.jpa.mvc.util.ItmsConstant.AMOUNT_DECIMAL_MIN;
import static com.jpa.mvc.util.ItmsConstant.AMOUNT_FRACTION;
import static com.jpa.mvc.util.ItmsConstant.AMOUNT_INTEGER;
import static com.jpa.mvc.util.ItmsConstant.LARGE_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.MEDIUM_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.NORMAL_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.SHORT_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.SHORT_PLUS_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.TEXT_FIELD_SIZE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.jpa.mvc.domain.Contact;
import com.jpa.mvc.domain.IdEntity;

@Entity
@Setter
@Getter
public class Customer extends IdEntity {

    private static final long serialVersionUID = -3228099226246029420L;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;

    @NotNull
    @Size(max = MEDIUM_FIELD_SIZE)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = LARGE_FIELD_SIZE)
    private String fullName;

    private boolean actived = true;


    @NotNull
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;
    
    @NotNull
    @ManyToOne
    private PaymentTerm paymentTerm;

    private boolean onRecorded = false;

    @NotNull
    @Digits(integer = AMOUNT_INTEGER, fraction = AMOUNT_FRACTION)
    @DecimalMin(AMOUNT_DECIMAL_MIN)
    private double paintCost;

    @NotNull
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    @Column(unique = true)
    private String sapCode;

    private Date contractStart;

    private Date contractEnd;

    @Valid
    @NotNull
    private Contact contact;

    @NotNull
    @Size(max = SHORT_FIELD_SIZE)
    private String postCode;

    @NotNull
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    private String fax;

    @NotNull
    @Size(max = TEXT_FIELD_SIZE)
    private String address;

    @Valid
    @ElementCollection
    private List<Shipping> shippings;

    @ElementCollection
    private Map<TradeClauseType, Double> tradeClauses;

    @Valid
    @ElementCollection
    private List<OverseaFactory> overseaFactories;

    @OneToOne(cascade = CascadeType.ALL)
    private PackCustomerInfo packCustomerInfo;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class OverseaFactory implements Serializable {

        private static final long serialVersionUID = 7470582335687839996L;

        @NotNull
        @Size(max = NORMAL_FIELD_SIZE)
        private String factoryName;

        @NotNull
        @Enumerated(EnumType.STRING)
        private TradeType tradeType;
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class Shipping implements Serializable {

        private static final long serialVersionUID = -3934059882523272918L;

        @NotNull
        @Enumerated(EnumType.STRING)
        private TradeType tradeType;

        @NotNull
        @Size(max = NORMAL_FIELD_SIZE)
        private String destination;
        
        @Size(max = NORMAL_FIELD_SIZE)
        private String declarationPort;

        @Size(max = MEDIUM_FIELD_SIZE)
        private String consignee;

        @Size(max = NORMAL_FIELD_SIZE)
        private String address;
    }

}
