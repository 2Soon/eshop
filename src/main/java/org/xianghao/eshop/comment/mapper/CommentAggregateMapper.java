package org.xianghao.eshop.comment.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xianghao.eshop.comment.domain.CommentAggregateDO;

/**
 * 评论统计信息管理模块的mapper组件
 * */
@Mapper
public interface CommentAggregateMapper {

    /**
     * 根据商品ID查询评论统计信息
     * @param goodsId
     * @return 评论统计信息
     * */
    @Select("SELECT" +
            "id," +
            "goods_id," +
            "total_comment_count," +
            "" +
            "" +
            "" +
            "" +
            "" +
            "")
    CommentAggregateDO getCommentAggregateByGoodsId(Long goodsId);
}
