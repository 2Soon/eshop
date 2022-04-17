package org.xianghao.eshop.auth.service;

import org.xianghao.eshop.auth.domain.PriorityDO;
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
    /**
     * 根据父权限id查询子权限
     *
     * @param parentId
     * @return 子权限
     */
    List<PriorityDTO> listChildPriorities(Long parentId);
    /**
     * 根据ID查询
     * @param id
     * @return PriorityDO权限DO
     * */
    PriorityDTO getPriorityById(Long id);

    /**
     * 新增权限
     *
     * @param priorityDTO 权限DO对象
     */
    Boolean savePriority(PriorityDTO priorityDTO);
    /**
     * 更新权限
     *
     * @param priorityDTO 权限DO对象
     */
    Boolean updatePriority(PriorityDTO priorityDTO);
    /**
     * 删除权限
     * @param id
     * */
    Boolean removePriority(Long id);
}
