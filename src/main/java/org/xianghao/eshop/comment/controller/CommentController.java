package org.xianghao.eshop.comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xianghao.eshop.comment.constant.ShowPictures;
import org.xianghao.eshop.comment.domain.CommentInfoDTO;
import org.xianghao.eshop.comment.domain.CommentInfoVO;
import org.xianghao.eshop.comment.service.CommentAggregateService;
import org.xianghao.eshop.comment.service.CommentInfoService;
import org.xianghao.eshop.comment.service.CommentPictureService;
import org.xianghao.eshop.membership.service.MembershipFacadeService;
import org.xianghao.eshop.order.service.OrderFacadeService;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论管理模块的Controller组件
 * */

@RestController
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    /**
     * 评论信息管理模块的service组件
     * */
    @Autowired
    private CommentInfoService commentInfoService;

    /**
     * 评论晒图管理模块的service组件
     * */
    @Autowired
    private CommentPictureService commentPictureService;

    /**
     * 评论统计信息service
     * */
    @Autowired
    private CommentAggregateService commentAggregateService;

    /**
     * 订单中心service组件
     * */
    private OrderFacadeService orderFacadeService;
    /**
     * 会员中心service组件
     * * */
    private MembershipFacadeService membershipFacadeService;

    /**
     * 手动发表评论
     * @param commentInfoVO
     * @return 处理结果
     * */
    @PostMapping("/")
    public Boolean publishComment(HttpServletRequest request,
                                  CommentInfoVO commentInfoVO,
                                  MultipartFile[] files){
        try {
            //设置是否晒图
            Integer showPictures = ShowPictures.NO;
            if (files!=null&& files.length>0){
                for (MultipartFile file : files) {
                    if (file!=null){
                        showPictures = ShowPictures.YES;
                    }
                }

            }
            commentInfoVO.setIsShowPictures(showPictures);

            //保存评论信息
            CommentInfoDTO commentInfoDTO = commentInfoVO.clone(CommentInfoDTO.class);
            commentInfoService.saveManualPublishedCommentInfo(commentInfoDTO);
            //上传评论晒图的图片
            String  appBasePath = request.getSession().getServletContext().getRealPath("/");
            commentPictureService.saveCommentPictures(appBasePath, commentInfoDTO.getId(), files);
            //更新评论统计信息
            commentAggregateService.updateCommentAggregate(commentInfoDTO);
            //通知订单中心订单以发表评论
            orderFacadeService.informPublishCommentEvent(commentInfoDTO.getOrderInfoId());
            //通知会员中心用户已发表评论
            membershipFacadeService.informPublishCommentEvent(commentInfoDTO.getUserAccountId(),ShowPictures.YES.equals(showPictures));

        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return null;

    }
}
