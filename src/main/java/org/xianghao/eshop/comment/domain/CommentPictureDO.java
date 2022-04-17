package org.xianghao.eshop.comment.domain;

import java.util.Date;

/**
 * 评论晒图
 * */
public class CommentPictureDO {
    private Long id;
    private Long commentInfoId;
//    private int sequence;
    private String commentPicturePath;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentInfoId() {
        return commentInfoId;
    }

    public void setCommentInfoId(Long commentInfoId) {
        this.commentInfoId = commentInfoId;
    }

    public String getCommentPicturePath() {
        return commentPicturePath;
    }

    public void setCommentPicturePath(String commentPicturePath) {
        this.commentPicturePath = commentPicturePath;
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
