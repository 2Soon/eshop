package org.xianghao.eshop.comment.service;

import org.xianghao.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论信息管理模块Service
 * */
public interface CommentInfoService {

    /**
     * 新增评论信息
     * @param commentInfoDTO
     * */
    Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO);
}
