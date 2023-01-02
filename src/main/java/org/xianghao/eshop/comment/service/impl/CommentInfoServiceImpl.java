package org.xianghao.eshop.comment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.auth.service.impl.PriorityServiceImpl;
import org.xianghao.eshop.comment.constant.*;
import org.xianghao.eshop.comment.dao.CommentInfoDAO;
import org.xianghao.eshop.comment.domain.CommentInfoDO;
import org.xianghao.eshop.comment.domain.CommentInfoDTO;
import org.xianghao.eshop.comment.service.CommentInfoService;
import org.xianghao.eshop.order.domain.OrderInfoDTO;
import org.xianghao.eshop.order.domain.OrderItemDTO;

import java.util.Date;

/**
 * 评论信息管理模块Service实现
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoServiceImpl.class);

    /**
     * 评论信息管理模块DAO
     */
    @Autowired
    private CommentInfoDAO commentInfoDAO;

    /**
     * 新增手动评论信息
     *
     * @param commentInfoDTO
     */
    @Override
    public Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO) {
        try {
            //对评论信息的一些数据进行处理
            //计算评论的总分数
            Integer goodsScore = commentInfoDTO.getGoodsScore();
            Integer customerServiceScore = commentInfoDTO.getCustomerServiceScore();
            Integer logisticsScore = commentInfoDTO.getLogisticsScore();
            Integer totalScore = Math.round((goodsScore + customerServiceScore + logisticsScore) / 3);
            commentInfoDTO.setTotalScore(totalScore);
            //设置评论的类型是否默认
            commentInfoDTO.setCommentType(DefaultComment.NO);
            //评论状态
            commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);
            //设置评论类型
            Integer commentType = 0;
            if (totalScore >= 4) {
                commentType = CommentType.GOOD_COMMENT;
            } else if (totalScore == 3) {
                commentType = CommentType.MEDIUM_COMMENT;
            } else if (totalScore > 0 && totalScore <= 2) {
                commentType = CommentType.BAD_COMMENT;
            }
            commentInfoDTO.setCommentType(commentType);
            //创建时间、修改时间
            commentInfoDTO.setGmtCreate(new Date());
            commentInfoDTO.setGmtModified(new Date());

            //将评论信息数据存到数据库
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);

            //设置评论信息的id
            commentInfoDTO.setId(commentInfoDO.getId());
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 新增自动评论信息
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * */
    @Override
    public CommentInfoDTO saveAutoPublishedCommentInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) {
        CommentInfoDTO commentInfoDTO = null;
        try {
            //对评论信息的一些数据进行处理
            //创建评论信息DTO对象
            commentInfoDTO = createCommentInfoDTO(orderInfoDTO, orderItemDTO);

            //将评论信息数据存到数据库
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);

            //设置评论信息的id
            commentInfoDTO.setId(commentInfoDO.getId());
        } catch (Exception e) {
            logger.error("error", e);
            return null;
        }
        return commentInfoDTO;
    }

    /**
     * 创建评论信息DTO
     * @param orderInfoDTO 订单信息DTO对象
     * @param orderItemDTO 订单条目DTO对象
     * @return 评论信息DTO对象
     * */
    private CommentInfoDTO createCommentInfoDTO(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO){
        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
        commentInfoDTO.setUserAccountId(orderInfoDTO.getUserAccountId());
        commentInfoDTO.setUsername(orderInfoDTO.getUsername());
        commentInfoDTO.setOrderInfoId(orderInfoDTO.getId());
        commentInfoDTO.setOrderItemId(orderItemDTO.getId());
        commentInfoDTO.setGoodsId(orderItemDTO.getGoodsId());
        commentInfoDTO.setGoodsSkuId(orderItemDTO.getGoodsSkuId());
        commentInfoDTO.setGoodsSkuSaleProperties(orderItemDTO.getSaleProperties());
        //计算评论的总分数
        commentInfoDTO.setTotalScore(CommentInfoScore.FIVE);
        commentInfoDTO.setGoodsScore(CommentInfoScore.FIVE);
        commentInfoDTO.setCustomerServiceScore(CommentInfoScore.FIVE);
        commentInfoDTO.setLogisticsScore(CommentInfoScore.FIVE);
        commentInfoDTO.setCommentContent(CommentContent.DEFAULT);
        //设置评论的类型是否默认
        commentInfoDTO.setCommentType(DefaultComment.YES);
        //晒图
        commentInfoDTO.setIsShowPictures(ShowPictures.NO);
        //评论状态
        commentInfoDTO.setCommentStatus(CommentStatus.APPROVED);
        //设置评论类型
        commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
        //创建时间、修改时间
        commentInfoDTO.setGmtCreate(new Date());
        commentInfoDTO.setGmtModified(new Date());

        return commentInfoDTO;
    }


}
