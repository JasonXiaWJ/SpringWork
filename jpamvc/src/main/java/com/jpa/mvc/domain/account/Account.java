package com.jpa.mvc.domain.account;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jpa.mvc.domain.IdEntity;
import com.jpa.mvc.domain.customer.Customer;
import com.jpa.mvc.util.ItmsConstant;

@Entity
@Setter
@Getter
public class Account extends IdEntity {

    private static final long serialVersionUID = 656068027711203525L;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    @JsonIgnore
    private String password = ItmsConstant.DEFAULT_PASSWORD;

    @NotEmpty
    private String name;

    private String department;

    private String telphone;

    private String email;

    @ManyToMany
    @JsonIgnoreProperties(value = { "fullName", "tradeClauseType", "paymentTerm", "currency", "onRecorded",
            "paintCost", "contractStart", "contractEnd", "contact", "postCode", "fax", "address", "shippings",
            "tradeClauses", "overseaFactories" }, ignoreUnknown = true)
    private List<Customer> customers;
    
    
    private boolean actived = true;

    public Account(String username, String name) {
        super();
        this.username = username;
        this.name = name;
    }

    public Account() {
    }
}
