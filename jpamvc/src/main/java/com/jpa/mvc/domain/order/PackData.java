package com.jpa.mvc.domain.order;

import static com.jpa.mvc.util.ItmsConstant.MEDIUM_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.QUANTITY_MIN;
import static com.jpa.mvc.util.ItmsConstant.SHORT_FIELD_SIZE;
import static com.jpa.mvc.util.ItmsConstant.SHORT_PLUS_FIELD_SIZE;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jpa.mvc.domain.IdEntity;

@Setter
@Getter
@MappedSuperclass
public class PackData extends IdEntity {


    /**
     * 
     */
    private static final long serialVersionUID = 4435234528121147024L;


    @ManyToOne
    @JoinColumn(name = "baseOrder")
    @JsonIgnoreProperties({ "shipments", "packs", "creator", "modifier", "paymentTerm", "loadingPort",
            "productionBase", "documents", "costItems", "items", "orderAuditState", "packOrderInfo" })
    protected BaseOrder baseOrder;

    /**
     * 集装箱号
     */
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    protected String contNo;

    /**
     * 封箱号
     */
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    protected String sealNo;

    /**
     * 包装日期
     */
    @DateTimeFormat(iso = ISO.DATE_TIME)
    protected Date packingDate;

    /**
     * 铁箱号/托盘号
     */
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    protected String caseNo;

    /**
     * 铁箱净重
     */
    @Size(max = SHORT_FIELD_SIZE)
    protected String nw;

    /**
     * 铁箱毛重
     */
    @Size(max = SHORT_FIELD_SIZE)
    protected String gw;

    /**
     * 体积
     */
    @Size(max = SHORT_FIELD_SIZE)
    protected String cum;

    /**
     * 铁箱尺寸，包装公司接口增加该字段；
     */
    @Size(max = MEDIUM_FIELD_SIZE)
    protected String measure;

    /**
     * 纸箱号
     */
    @Size(max = SHORT_PLUS_FIELD_SIZE)
    protected String caNo;

    /**
     * 纸箱尺寸，包装公司接口增加该字段；
     */
    @Size(max = MEDIUM_FIELD_SIZE)
    protected String caMeasure;

    /**
     * 零件
     */
    @JsonIgnoreProperties({ "version", "otherDescription", "netWeight", "grossWeight", "volume", "hsCode", "kayParts",
            "setPart", "productionBase", "actived" })


    /**
     * 零件数量
     */
    @Min(QUANTITY_MIN)
    protected int quantity;

    /**
     * 零件净重
     */
    @Size(max = SHORT_FIELD_SIZE)
    protected String materialNw;

    /**
     * 零件毛重
     */
    @Size(max = SHORT_FIELD_SIZE)
    protected String materialGw;


}