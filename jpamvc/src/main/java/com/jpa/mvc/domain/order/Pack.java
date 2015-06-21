package com.jpa.mvc.domain.order;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "baseOrder", "contNo", "caseNo", "caNo" }) })
public class Pack extends PackData {

    private static final long serialVersionUID = -8321587782229709244L;

    
}
