package org.xianghao.eshop.comment.service;

import org.xianghao.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论统计信息管理模块的service组件接口
 * */
public interface CommentAggregateService {

    /**
     * 更新评论统计信息
     * @param commentInfoDTO 评论信息
     * @return 处理结果
     */
    Boolean updateCommentAggregate(CommentInfoDTO commentInfoDTO);
}
