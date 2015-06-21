package com.jpa.mvc.domain;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jpa.mvc.domain.account.Account;

@Getter
@Setter
@MappedSuperclass
public abstract class Record extends IdEntity {

    private static final long serialVersionUID = 5736099774632197759L;

    @CreatedBy
    @ManyToOne
    @JsonIgnoreProperties("roles")
    private Account creator;

    @CreatedDate
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private Date createdDate;

    @LastModifiedBy
    @ManyToOne
    @JsonIgnoreProperties("roles")
    private Account modifier;

    @LastModifiedDate
    private Date modifiedDate;

}
