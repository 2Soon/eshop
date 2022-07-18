package org.xianghao.eshop.comment.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 评论聚合统计信息
 * */
public class CommentAggregateDO {
    private Long id;
    private Long goodsId;
    private Long totalCommentCount;
    private Long goodCommentCount;
    private BigDecimal goodCommentRate;
    private Long showPicturesCommentCount;
    private Long mediumCommentCount;
    private Long badCommentCount;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Long totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public Long getGoodCommentCount() {
        return goodCommentCount;
    }

    public void setGoodCommentCount(Long goodCommentCount) {
        this.goodCommentCount = goodCommentCount;
    }

    public BigDecimal getGoodCommentRate() {
        return goodCommentRate;
    }

    public void setGoodCommentRate(BigDecimal goodCommentRate) {
        this.goodCommentRate = goodCommentRate;
    }

    public Long getShowPicturesCommentCount() {
        return showPicturesCommentCount;
    }

    public void setShowPicturesCommentCount(Long showPicturesCommentCount) {
        this.showPicturesCommentCount = showPicturesCommentCount;
    }

    public Long getMediumCommentCount() {
        return mediumCommentCount;
    }

    public void setMediumCommentCount(Long mediumCommentCount) {
        this.mediumCommentCount = mediumCommentCount;
    }

    public Long getBadCommentCount() {
        return badCommentCount;
    }

    public void setBadCommentCount(Long badCommentCount) {
        this.badCommentCount = badCommentCount;
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
