package org.xianghao.eshop.comment.domain;

import java.util.Date;

/**
 * 评论信息
 * */
public class CommentInfoDO {
    private Long id;
    private Long userAccountId;
    private String username;
    /**
     * 订单信息ID
     * */
    private Long orderInfoId;
    /**
     * 订单条目ID
     * */
    private Long orderItemId;
    /**
     * 订单条目对应的商品ID
     * */
    private Long goodsId;
    /**
     * 订单条目对应的商品SKUID
     * */
    private Long goodsSkuId;
    /**
     * 商品SKU销售属性
     * */
    private String goodsSkuSaleProperties;
    /**
     * 总评分 = 商品评分+客服评分+物流评分
     * */
    private Integer totalScore;
    private Integer goodsScore;
    private Integer customerServiceScore;
    private Integer logisticsScore;
    private String commentContent;
    private Integer isShowPictures;
    private Integer isDefaultComment;
    private Integer commentStatus;
    private Integer commentType;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuSaleProperties() {
        return goodsSkuSaleProperties;
    }

    public void setGoodsSkuSaleProperties(String goodsSkuSaleProperties) {
        this.goodsSkuSaleProperties = goodsSkuSaleProperties;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    public Integer getCustomerServiceScore() {
        return customerServiceScore;
    }

    public void setCustomerServiceScore(Integer customerServiceScore) {
        this.customerServiceScore = customerServiceScore;
    }

    public Integer getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(Integer logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getIsShowPictures() {
        return isShowPictures;
    }

    public void setIsShowPictures(Integer isShowPictures) {
        this.isShowPictures = isShowPictures;
    }

    public Integer getIsDefaultComment() {
        return isDefaultComment;
    }

    public void setIsDefaultComment(Integer isDefaultComment) {
        this.isDefaultComment = isDefaultComment;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
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
}
