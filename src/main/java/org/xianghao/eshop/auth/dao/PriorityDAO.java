package org.xianghao.eshop.auth.dao;

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

}
