package org.xianghao.eshop.commodity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.commodity.dao.PropertyDAO;
import org.xianghao.eshop.commodity.domain.PropertyDO;
import org.xianghao.eshop.commodity.domain.PropertyDTO;
import org.xianghao.eshop.commodity.domain.PropertyQuery;
import org.xianghao.eshop.commodity.service.PropertyService;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性管理模块Service组件
 * */
@Service
public class PropertyServiceImpl implements PropertyService {

    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
    /**
     * 商品属性管理DAO组件
     * */
    @Autowired
    private PropertyDAO propertyDAO;

    /**
     * 分页查询商品属性
     * @param propertyQuery 查询条件
     * @return 商品属性
     */
    @Override
    public List<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery) {
        try {
            List<PropertyDO> propertyDOS = propertyDAO.listPropertiesByPage(propertyQuery);
            List<PropertyDTO> propertyDTOS = new ArrayList<PropertyDTO>(propertyDOS.size());

            for (PropertyDO propertyDO : propertyDOS) {
                propertyDTOS.add(propertyDO.clone(PropertyDTO.class));

            }
            return propertyDTOS;

        }catch (Exception e){
            logger.error("error",e);
        }
        return new ArrayList<PropertyDTO>();
    }
    /**
     * 新增商品属性
     * @param propertyDTO 商品属性DO对象
     */
    @Override
    public Boolean saveProperty(PropertyDTO propertyDTO) {

        try {
            PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
            propertyDAO.saveProperty(propertyDO);

        } catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;
    }
    /**
     * 根据id查询商品属性
     * @param id 商品属性id
     * @return 商品属性
     */
    @Override
    public PropertyDTO getPropertyById(Long id) {
        try {
            PropertyDO propertyDO = propertyDAO.getPropertyById(id);
            return propertyDO.clone(PropertyDTO.class);
        }catch (Exception e){
            logger.error("error",e);
        }
        return new PropertyDTO();
    }
    /**
     * 更新商品属性
     * @param propertyDTO 商品属性DO对象
     */
    @Override
    public Boolean updateProperty(PropertyDTO propertyDTO) {
        try {
            PropertyDO propertyDO = propertyDTO.clone(PropertyDO.class);
            propertyDAO.updateProperty(propertyDO);
        } catch (Exception e) {
            logger.error("error",e);
            return false;
        }
        return true;

    }
}
