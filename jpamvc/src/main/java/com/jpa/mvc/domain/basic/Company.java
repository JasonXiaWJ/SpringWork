package com.jpa.mvc.domain.basic;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import com.jpa.mvc.domain.IdEntity;
import com.jpa.mvc.util.ItmsConstant;

/**
 * Company entity for keeping company data.
 * 
 * @author u123250
 * 
 */
@Entity
@Setter
@Getter
public class Company extends IdEntity {

    private static final long serialVersionUID = 2290010665119281650L;

    /**
     * Chinese name
     */
    @Size(max = ItmsConstant.MEDIUM_FIELD_SIZE)
    private String chineseName;

    /**
     * English name
     */
    @Size(max = ItmsConstant.MEDIUM_FIELD_SIZE)
    private String englishName;

    /**
     * Russian name
     */
    @Size(max = ItmsConstant.MEDIUM_FIELD_SIZE)
    private String russianName;

    /**
     * Company address
     */
    @Size(max = ItmsConstant.NORMAL_FIELD_SIZE)
    private String address;

    /**
     * Bank name
     */
    @Size(max = ItmsConstant.MEDIUM_FIELD_SIZE)
    private String bankName;

    /**
     * Bank address
     */
    @Size(max = ItmsConstant.NORMAL_FIELD_SIZE)
    private String bankAddress;

    /**
     * Swift code
     */
    @Size(max = ItmsConstant.SHORT_PLUS_FIELD_SIZE)
    private String swiftCode;

    /**
     * A/C No
     */
    @Size(max = ItmsConstant.SHORT_PLUS_FIELD_SIZE)
    private String acNo;

    /**
     * Payee
     */
    @Size(max = ItmsConstant.MEDIUM_FIELD_SIZE)
    private String payee;

    /**
     * Payee address
     */
    @Size(max = ItmsConstant.NORMAL_FIELD_SIZE)
    private String payeeAddress;

    /**
     * Telephone
     */
    @Size(max = ItmsConstant.SHORT_PLUS_FIELD_SIZE)
    private String telephone;

    /**
     * Fax
     */
    @Size(max = ItmsConstant.SHORT_PLUS_FIELD_SIZE)
    private String fax;
}
