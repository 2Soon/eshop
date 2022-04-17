package org.xianghao.eshop.comment.dao;

import org.xianghao.eshop.comment.domain.CommentInfoDO;

/**
 * 评论信息管理模块DAO
 * */
public interface CommentInfoDAO {

    /**
     * 新增评论信息
     * @param commentInfoDO
     * */
    Boolean saveCommentInfo(CommentInfoDO commentInfoDO);

}
