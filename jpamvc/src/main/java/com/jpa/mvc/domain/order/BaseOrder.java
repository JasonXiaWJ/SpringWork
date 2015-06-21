package com.jpa.mvc.domain.order;

import static com.jpa.mvc.util.ItmsConstant.NORMAL_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.SHORT_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.TEXT_FIELD_SIZE;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jpa.mvc.domain.Attachment;
import com.jpa.mvc.domain.Record;
import com.jpa.mvc.domain.customer.CurrencyCode;
import com.jpa.mvc.domain.customer.Customer;
import com.jpa.mvc.domain.customer.TradeClauseType;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseOrder extends Record {
    private static final long serialVersionUID = 178614086319748968L;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(unique = true, nullable = false)
    private String no;

    @ManyToOne
    @NotNull
    private Customer customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TradeClauseType tradeClauseType;

    /*
     * 目的港
     */
    @NotNull
    @Size(max = NORMAL_FIELD_SIZE)
    private String destination;

    @Size(max = TEXT_FIELD_SIZE)
    private String remark;

    /*
     * 其他费用
     */
    @ElementCollection
    @Valid
    private List<CostItem> costItems;

    /*
     * 相关单证
     */
    @OneToMany(cascade = CascadeType.REMOVE)
    @Valid
    private List<Attachment> documents;



    /*
     * 装箱信息
     */
    @OneToMany(mappedBy = "baseOrder")
    private List<Pack> packs;

    

    @NotNull
    @Column(length = SHORT_FIELD_SIZE)
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;
    /*
     * 领料通知日期
     */
    private Date pickingDate;
    
    /**
     * Different order types
     */
    public enum Type {
        SUBCKD, SKD, CKD, IKD, NORMALPBP, CLAIMPBP, MATERIALCLAIM
    }

    /**
     * 返回FOb金额
     * @return
     */
    public double retrieveSaleAmount() {
        return 0;
    }

    public double retrieveOtherCostAmount() {
        double amount = 0;
        for (CostItem item : costItems) {
            amount += item.getAmount();
        }
        return amount;
    }
    public double retrieveOtherCostAmount(String sapCode) {
        double amount = 0;
        for (CostItem item : costItems) {
            if(sapCode.equals(item.getCostType().getSapCode())){
                amount += item.getAmount();
            }
        }
        return amount;
    }
    

    /**
     * 比例 = 1 + (其他费用)/(订单台套，SUBCKD，索赔，PBP零件的销售总价 + 台套零件的选装包的销售总价)
     * 
     * 用于计算箱单中的零件价格，实际单价=FOB单价×比例
     */
    public double retrieveRate() {
        return 1 + retrieveOtherCostAmount() / retrieveSaleAmount();
    }



}
