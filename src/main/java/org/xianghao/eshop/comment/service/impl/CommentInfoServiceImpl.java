package org.xianghao.eshop.comment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.auth.service.impl.PriorityServiceImpl;
import org.xianghao.eshop.comment.constant.CommentStatus;
import org.xianghao.eshop.comment.constant.CommentType;
import org.xianghao.eshop.comment.constant.DefaultComment;
import org.xianghao.eshop.comment.dao.CommentInfoDAO;
import org.xianghao.eshop.comment.domain.CommentInfoDO;
import org.xianghao.eshop.comment.domain.CommentInfoDTO;
import org.xianghao.eshop.comment.service.CommentInfoService;

import java.util.Date;

/**
 * 评论信息管理模块Service实现
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PriorityServiceImpl.class);

    /**
     * 评论信息管理模块DAO
     */
    @Autowired
    private CommentInfoDAO commentInfoDAO;

    /**
     * 新增评论信息
     *
     * @param commentInfoDTO
     */
    @Override
    public Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO) {
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


}
