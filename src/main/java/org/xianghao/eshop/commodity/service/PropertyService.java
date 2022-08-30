package org.xianghao.eshop.commodity.service;

import org.apache.ibatis.annotations.Param;
import org.xianghao.eshop.commodity.domain.PropertyDTO;
import org.xianghao.eshop.commodity.domain.PropertyQuery;

import java.util.List;

/**
 * 商品属性管理模块Service组件接口
 * */
public interface PropertyService {

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    List<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery);
    /**
     * 新增商品属性
     * @param propertyDTO 商品属性DO对象
     */
    Boolean saveProperty(PropertyDTO propertyDTO);
    /**
     * 根据id查询商品属性
     * @param id 商品属性id
     * @return 商品属性
     */
    PropertyDTO getPropertyById(@Param("id") Long id);
    /**
     * 更新商品属性
     * @param propertyDTO 商品属性DO对象
     */
    Boolean updateProperty(PropertyDTO propertyDTO);
}
