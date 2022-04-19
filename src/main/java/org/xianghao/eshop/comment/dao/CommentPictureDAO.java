package org.xianghao.eshop.comment.dao;

import org.xianghao.eshop.comment.domain.CommentPictureDO;

/**
 * 评论晒图模块的dao组件接口
 */
public interface CommentPictureDAO {

    /**
     * 新增评论晒图
     * @param commentPictureDO
     */
    Boolean saveCommentPicture(CommentPictureDO commentPictureDO);

}
