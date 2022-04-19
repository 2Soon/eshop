package org.xianghao.eshop.comment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.xianghao.eshop.comment.controller.CommentController;
import org.xianghao.eshop.comment.dao.CommentPictureDAO;
import org.xianghao.eshop.comment.service.CommentPictureService;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论晒图模块的Service组件
 */
public class CommentPictureServiceImpl implements CommentPictureService {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentPictureDAO commentPictureDAO;

    /**
     * 评论晒图的上传目录类型：relative 相对，absolute 绝对
     * */
    @Value("${comment.picture.upload.dir.type}")
    private String uploadDirType;

    /**
     * 评论晒图的上传目录
     * */
    @Value("${comment.picture.upload.dir}")
    private String uploadDir;


    /**
     * 保存评论晒图
     *
     * @param appBasePath 当前应用根路径
     * @param commentInfoId 评论信息ID
     * @param files 评论晒图
     * @return 处理结果
     */
    @Override
    public Boolean saveCommentPictures(String appBasePath, Long commentInfoId, MultipartFile[] files) {
        try {
            //处理上传目录
            //如果是相对路径
            if (uploadDir.startsWith("/")){
                uploadDir = appBasePath+uploadDir;
            }
            // todo
            //将图片上传到指定的目录中

        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }



}
