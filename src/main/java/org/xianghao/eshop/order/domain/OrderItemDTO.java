package org.xianghao.eshop.order.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单条目DTO类
 * */
public class OrderItemDTO {
    private Long id;
    private Long orderInfoId;
    private Long goodsSkuId;
    /**
     * goodsId
     * */
    private Long goodsId;
    private String goodsSkuCode;
    private String goodsName;
    /**
     * 销售属性
     * */
    private String saleProperties;
    /**
     * 商品毛重
     * */
    private BigDecimal goodsGrossWeight;
    /**
     * 购买数量
     * */
    private Long purchaseQuantity;
    /**
     * 购买价格
     * */
    private BigDecimal purchasePrice;
    /**
     * 商品SKU使用的促销活动ID
     * */
    private Long promotionActivityId;
    private BigDecimal goodsLength;
    private BigDecimal goodsWidth;
    private BigDecimal goodsHeight;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderId) {
        this.orderInfoId = orderId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuCode() {
        return goodsSkuCode;
    }

    public void setGoodsSkuCode(String goodsSkuCode) {
        this.goodsSkuCode = goodsSkuCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSaleProperties() {
        return saleProperties;
    }

    public void setSaleProperties(String saleProperties) {
        this.saleProperties = saleProperties;
    }

    public BigDecimal getGoodsGrossWeight() {
        return goodsGrossWeight;
    }

    public void setGoodsGrossWeight(BigDecimal goodsGrossWeight) {
        this.goodsGrossWeight = goodsGrossWeight;
    }

    public Long getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getPromotionActivityId() {
        return promotionActivityId;
    }

    public void setPromotionActivityId(Long promotionActivityId) {
        this.promotionActivityId = promotionActivityId;
    }

    public BigDecimal getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(BigDecimal goodsLength) {
        this.goodsLength = goodsLength;
    }

    public BigDecimal getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(BigDecimal goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public BigDecimal getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(BigDecimal goodsHeight) {
        this.goodsHeight = goodsHeight;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
