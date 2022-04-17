package org.xianghao.eshop.comment.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.xianghao.eshop.comment.domain.CommentInfoDO;

/**
 * 评论信息管理模块的mapper组件
 * */
@Mapper
public interface CommentInfoMapper {

    /**
     * 新增评论信息
     * @param commentInfoDO
     * */
    @Insert("INSERT INTO comment_info(" +
            "user_account_id," +
            "username," +
            "order_info_id," +
            "order_item_id," +
            "goods_id," +
            "goods_sku_id," +
            "goods_sku_sale_properties," +
            "total_score," +
            "goods_score," +
            "customer_service_score," +
            "logistics_score," +
            "comment_content," +
            "is_show_pictures," +
            "is_default_comment," +
            "comment_status" +
            "comment_type" +
            "gmt_create" +
            "gmt_modified" +
            ")" +
            "VALUES(" +
            "#{userAccountId}," +
            "#{username}," +
            "#{orderInfoId}," +
            "#{orderItemId}," +
            "#{goodsId}," +
            "#{goodsSkuId}," +
            "#{goodsSkuSaleProperties}," +
            "#{totalScore}," +
            "#{goodsScore}," +
            "#{customerService_score}," +
            "#{logisticsScore}," +
            "#{commentContent}," +
            "#{isShowPictures}," +
            "#{isDefaultComment}," +
            "#{commentStatus}," +
            "#{commentType}," +
            "#{gmtCreate}," +
            "#{gmtModified}" +
            ")")
    void saveCommentInfo(CommentInfoDO commentInfoDO);
}
