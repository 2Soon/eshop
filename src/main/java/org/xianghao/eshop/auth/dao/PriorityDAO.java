package org.xianghao.eshop.auth.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.xianghao.eshop.auth.domain.PriorityDO;

import java.util.List;

/**
 * 权限管理模块DAO组件
 * */
public interface PriorityDAO {
    /**
     * 查询根权限列表
     * @Return 根权限集合
     * */
    List<PriorityDO> listRootPriorities();

    /**
     * 根据父权限查询子权限
     * @param parentId 父权限
     * @return 子权限
     * */
    List<PriorityDO> listChildPriorities(Long parentId);

    /**
     * 根据ID查询
     * @param id
     * @return PriorityDO权限DO
     * */
    PriorityDO getPriorityById(Long id);

    /**
     * 新增权限
     *
     * @param priorityDO 权限DO对象
     */
    Boolean savePriority(PriorityDO priorityDO);
    /**
     * 更新权限
     *
     * @param priorityDO 权限DO对象
     */
    Boolean updatePriority(PriorityDO priorityDO);
    /**
     * 删除权限
     * @param id
     * */
    Boolean removePriority(Long id);
}
