package org.xianghao.eshop.comment.service;

import org.springframework.web.multipart.MultipartFile;
import org.xianghao.eshop.comment.domain.CommentPictureDO;

/**
 * 评论晒图模块的Service组件接口
 */
public interface CommentPictureService {

    /**
     * 保存评论晒图
     *
     * @param appBasePath 当前应用根路径
     * @param commentInfoId 评论信息ID
     * @param files 评论晒图
     * @return 处理结果
     */
    Boolean saveCommentPictures(String appBasePath,Long commentInfoId, MultipartFile[] files);

}
