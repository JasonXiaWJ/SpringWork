package com.jpa.mvc.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class IdEntity implements Serializable {
    private static final long serialVersionUID = -5554308939380869754L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    for per
//    @GeneratedValue(generator = "paymentableGenerator")    
//    @GenericGenerator(name = "paymentableGenerator", strategy = "increment")  
    private Long id;

    @Version
    private int version;
}