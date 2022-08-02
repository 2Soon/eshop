package org.xianghao.eshop.comment.service;

import org.xianghao.eshop.comment.domain.CommentInfoDTO;
import org.xianghao.eshop.order.domain.OrderInfoDTO;
import org.xianghao.eshop.order.domain.OrderItemDTO;

/**
 * 评论信息管理模块Service
 * */
public interface CommentInfoService {

    /**
     * 新增手动评论信息
     * @param commentInfoDTO
     * */
    Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO);

    /**
     * 新增自动评论信息
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * */
    CommentInfoDTO saveAutoPublishedCommentInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO);
}
