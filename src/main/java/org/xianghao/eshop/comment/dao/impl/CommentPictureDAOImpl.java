package org.xianghao.eshop.comment.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xianghao.eshop.comment.dao.CommentPictureDAO;
import org.xianghao.eshop.comment.domain.CommentPictureDO;
import org.xianghao.eshop.comment.mapper.CommentPictureMapper;

/**
 * 评论晒图模块的dao组件
 */
@Repository
public class CommentPictureDAOImpl implements CommentPictureDAO {
    private static final Logger logger = LoggerFactory.getLogger(CommentPictureDAOImpl.class);


    @Autowired
    private CommentPictureMapper commentPictureMapper;

    /**
     * 新增评论晒图
     * @param commentPictureDO
     */
    @Override
    public Boolean saveCommentPicture(CommentPictureDO commentPictureDO) {
        try {
            commentPictureMapper.saveCommentPicture(commentPictureDO);

        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
}
