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
import org.xianghao.eshop.comment.service.CommentInfoService;

/**
 * 评论管理模块的Controller组件
 * */

@RestController
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentInfoService commentInfoService;

    /**
     * 手动发表评论
     * @param commentInfoVO
     * @return 处理结果
     * */
    @PostMapping("/")
    public Boolean publishComment(CommentInfoVO commentInfoVO, MultipartFile[] files){
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
            commentInfoService.saveCommentInfo(commentInfoDTO);
            //上传评论晒图的图片
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return null;

    }
}
