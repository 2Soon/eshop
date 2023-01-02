//package org.xianghao.eshop.comment.schedule;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.xianghao.eshop.comment.constant.CommentInfoScore;
//import org.xianghao.eshop.comment.domain.CommentInfoDTO;
//import org.xianghao.eshop.comment.service.CommentAggregateService;
//import org.xianghao.eshop.comment.service.CommentInfoService;
//import org.xianghao.eshop.order.domain.OrderInfoDTO;
//import org.xianghao.eshop.order.domain.OrderItemDTO;
//import org.xianghao.eshop.order.service.OrderFacadeService;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 自动发表评论调度任务
// */
//@Component
//public class AutoPublishCommentTask {
//
//    private static final Logger logger = LoggerFactory.getLogger(AutoPublishCommentTask.class);
//    /**
//     * 订单中心service组件
//     * *
//     */
//    @Autowired
//    private OrderFacadeService orderFacadeService;
//
//    /**
//     * 评论信息service组件
//     */
//    @Autowired
//    private CommentInfoService commentInfoService;
//
//    /**
//     * 评论统计信息service组件
//     */
//    @Autowired
//    private CommentAggregateService commentAggregateService;
//
//    /**
//     * 每隔10分钟自动检查一次
//     */
//    @Scheduled(fixedRate = 10 * 60 * 1000)
//    public void execute() {
//        try {
//            //先从订单中心查询确认时间超过7天，但没有发表评论但订单
//            List<OrderInfoDTO> orderInfoDTOS = orderFacadeService.ListNotPublishedCommentOrders();
//            List<Long> orderInfoIds = new ArrayList<Long>(orderInfoDTOS.size());
//
//            if (null != orderInfoDTOS && orderInfoDTOS.size() > 0) {
//                //遍历所有订单
//                for (OrderInfoDTO orderInfoDTO : orderInfoDTOS) {
//                    if (orderInfoDTO.getOrderItems() == null || orderInfoDTO.getOrderItems().size() == 0) {
//                        continue;
//                    }
//                    orderInfoIds.add(orderInfoDTO.getId());
//
//                    //遍历所有订单项
//                    for (OrderItemDTO orderItemDTO : orderInfoDTO.getOrderItems()) {
//                        //保存自动发表的评论信息
//                        CommentInfoDTO commentInfoDTO = commentInfoService.saveAutoPublishedCommentInfo(orderInfoDTO, orderItemDTO);
//                        //更新统计信息
//                        commentAggregateService.updateCommentAggregate(commentInfoDTO);
//                    }
//                }
//            }
//            //通知订单中心，批量发表类评论
//            orderFacadeService.informBatchPublishCommentEvent(orderInfoIds);
//        } catch (Exception e) {
//
//        }
//
//    }
//}
