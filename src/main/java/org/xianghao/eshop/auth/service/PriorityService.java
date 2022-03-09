package org.xianghao.eshop.auth.service;

import org.xianghao.eshop.auth.domain.PriorityDTO;

import java.util.List;
/**
 * 权限管理模块service组件接口
 * */
public interface PriorityService {
    /**
     * 查询根权限
     * @Return 根权限集合
     * */
    List<PriorityDTO> listRootPriorities();
}
