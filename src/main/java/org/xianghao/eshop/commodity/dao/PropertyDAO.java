package org.xianghao.eshop.commodity.dao;

import org.apache.ibatis.annotations.Param;
import org.xianghao.eshop.commodity.domain.PropertyDO;
import org.xianghao.eshop.commodity.domain.PropertyQuery;

import java.util.List;

/**
 * 商品属性管理模块的DAO接口
 * */
public interface PropertyDAO {

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    List<PropertyDO> listPropertiesByPage(PropertyQuery propertyQuery);
    /**
     * 新增商品属性
     * @param propertyDO 商品属性DO对象
     */
    Boolean saveProperty(PropertyDO propertyDO);
    /**
     * 根据id查询商品属性
     * @param id 商品属性id
     * @return 商品属性
     */
    PropertyDO getPropertyById(@Param("id") Long id);
    /**
     * 更新商品属性
     * @param propertyDO 商品属性DO对象
     */
    Boolean updateProperty(PropertyDO propertyDO);


}
