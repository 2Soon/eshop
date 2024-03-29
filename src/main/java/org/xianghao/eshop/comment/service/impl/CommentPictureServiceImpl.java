package org.xianghao.eshop.comment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.xianghao.eshop.comment.controller.CommentController;
import org.xianghao.eshop.comment.dao.CommentPictureDAO;
import org.xianghao.eshop.comment.domain.CommentPictureDO;
import org.xianghao.eshop.comment.service.CommentPictureService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * 评论晒图模块的Service组件
 */
public class CommentPictureServiceImpl implements CommentPictureService {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentPictureDAO commentPictureDAO;

    /**
     * 评论晒图的上传目录类型：relative 相对，absolute 绝对
     */
    @Value("${comment.picture.upload.dir.type}")
    private String uploadDirType;

    /**
     * 评论晒图的上传目录
     */
    @Value("${comment.picture.upload.dir}")
    private String uploadDirPath;


    /**
     * 保存评论晒图
     *
     * @param appBasePath   当前应用根路径
     * @param commentInfoId 评论信息ID
     * @param files         评论晒图
     * @return 处理结果
     */
    @Override
    public Boolean saveCommentPictures(String appBasePath, Long commentInfoId, MultipartFile[] files) {
        try {
            //处理上传目录
            //如果是相对路径
            if (uploadDirPath.startsWith("/")) {
                uploadDirPath = appBasePath + uploadDirPath;
            }
            //将图片上传到指定的目录中
            // 如果上传目录不存在，则自动创建该目录
            File uploadDir = new File(uploadDirPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            for (MultipartFile file : files) {
                if (file == null) {
                    continue;
                }

                // 如果目标文件路径已经存在，则删除目标文件
                String fileSeparator = System.getProperties().getProperty("file.separator");
                String targetFilePath = uploadDirPath + fileSeparator + file.getOriginalFilename();
                File targetFile = new File(targetFilePath);
                if (targetFile.exists()) {
                    targetFile.delete();
                }

                // 将上传上来的文件保存到指定的文件中去
                file.transferTo(targetFile);

                // 将评论晒图信息保存到数据库中去
                CommentPictureDO commentPictureDO = new CommentPictureDO();
                commentPictureDO.setCommentInfoId(commentInfoId);
                commentPictureDO.setCommentPicturePath(targetFilePath);
                commentPictureDO.setGmtCreate(new Date());
                commentPictureDO.setGmtModified(new Date());

                commentPictureDAO.saveCommentPicture(commentPictureDO);
            }


        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }


}
