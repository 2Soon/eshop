package org.xianghao.eshop.comment.dao.impl;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xianghao.eshop.auth.service.impl.PriorityServiceImpl;
import org.xianghao.eshop.comment.dao.CommentInfoDAO;
import org.xianghao.eshop.comment.domain.CommentInfoDO;
import org.xianghao.eshop.comment.mapper.CommentInfoMapper;

/**
 * 评论信息管理模块DAO实现
 * */
@Repository
public class CommentInfoDAOImpl implements CommentInfoDAO {
    private static final Logger logger = LoggerFactory.getLogger(CommentInfoDAOImpl.class);

    /**
     * 评论信息管理模块的mapper组件
     * */
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    /**
     * 新增评论信息
     * @param commentInfoDO
     * */
    @Override
    public Boolean saveCommentInfo(CommentInfoDO commentInfoDO) {
        try {
            commentInfoMapper.saveCommentInfo(commentInfoDO);

        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
}
