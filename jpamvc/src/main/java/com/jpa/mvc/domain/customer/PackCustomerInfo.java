package com.jpa.mvc.domain.customer;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import com.jpa.mvc.domain.IdEntity;

@Getter
@Setter
@Entity
public class PackCustomerInfo extends IdEntity {

    private static final long serialVersionUID = 8993516887583761301L;

    private String toer;
    private String toerRu;
    private String buyer;
    private String buyerRu;
    private String consignee;
    private String consigneeRu;

}
