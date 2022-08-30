package org.xianghao.eshop.commodity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xianghao.eshop.commodity.domain.PropertyDTO;
import org.xianghao.eshop.commodity.domain.PropertyQuery;
import org.xianghao.eshop.commodity.domain.PropertyVO;
import org.xianghao.eshop.commodity.service.PropertyService;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性管理模块的controller组件
 */
@RestController
@RequestMapping("/commodity/property")
public class PropertyController {

    private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    /**
     * 商品属性管理模块service组件
     * *
     */
    @Autowired
    private PropertyService propertyService;

    /**
     * 分页查询商品属性
     *
     * @param propertyQuery
     * @return 商品属性
     */
    @GetMapping("/")
    public List<PropertyVO> listPropertiesByPage(PropertyQuery propertyQuery) {

        try {
            List<PropertyDTO> propertyDTOS = propertyService.listPropertiesByPage(propertyQuery);
            List<PropertyVO> propertyVOS = new ArrayList<PropertyVO>(propertyDTOS.size());

            for (PropertyDTO propertyDTO : propertyDTOS) {
                propertyVOS.add(propertyDTO.clone(PropertyVO.class));
            }
            return propertyVOS;

        } catch (Exception e) {
            logger.error("error", e);
        }
        return new ArrayList<PropertyVO>();

    }

    /**
     * 新增商品属性
     *
     * @param propertyVO 商品属性VO
     * @return 处理结果
     */
    @PostMapping("/")
    public Boolean saveProperty(@RequestBody PropertyVO propertyVO) {
        try {
            PropertyDTO propertyDTO = propertyVO.clone(PropertyDTO.class);
            propertyService.saveProperty(propertyDTO);

        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 根据商品ID查询
     * @param id 商品属性id
     * @return 商品属性
     * */
    @GetMapping("/{id}")
    public PropertyVO getPropertyById(@PathVariable("id") Long id){

        try {
            PropertyDTO propertyDTO = propertyService.getPropertyById(id);
            return propertyDTO.clone(PropertyVO.class);

        } catch (Exception e) {
            logger.error("error", e);

        }
        return new PropertyVO();
    }

    /**
     * 更新商品属性
     * @param propertyVO 商品属性VO
     * @return 处理结果
     * * */
    @PutMapping("/{id}")
    public Boolean updateProperty(@RequestBody PropertyVO propertyVO){
        try {
            PropertyDTO propertyDTO = propertyVO.clone(PropertyDTO.class);
            propertyService.updateProperty(propertyDTO);
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

}
