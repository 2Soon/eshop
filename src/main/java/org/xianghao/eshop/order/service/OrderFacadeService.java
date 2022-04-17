package org.xianghao.eshop.order.service;


import org.xianghao.eshop.order.domain.OrderInfoDTO;

import java.util.List;

/**
 * 订单中心对外接口
 *
 * */
public interface OrderFacadeService {
    /**
     * 通知订单中心，商品完成发货事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informGoodsDeliveryFinishedEvent(Long orderId);

    /**
     * 通知订单中心，退货工单审核不通过事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId);

    /**
     * 通知订单中心，退货工单审核通过事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informReturnGoodsWorsheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心，确认收到退货商品事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informReturnGoodsReceivedEvent(Long orderId);

    /**
     * 通知订单中心，退货入库单审核通过事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informReturnGoodsWarehouseEntryOrderApprovedEvent(Long orderId);
    /**
     * 通知订单中心，财务中心完成退款事件发生了
     * @param orderId 订单ID
     * @return 处理结果
     * */
    Boolean informRefundFinishedEvent(Long orderId);

    /**
     * 通知订单中心，订单发表评论事件发生了
     * @param orderId
     * */
    Boolean informPublishCommentEvent(Long orderId);

    /**
     * 从订单中心，确认收货时间超过了7天，而且还没有发表评论的订单
     * @return 订单信息DTO集合
     * */
    List<OrderInfoDTO> ListNotPublishedCommentOrders();

    /**
     *通知订单中心，订单批量发表评论事件发生了
     * */
    Boolean informBatchPublishCommentEvent(List<Long> orderIds);
}
