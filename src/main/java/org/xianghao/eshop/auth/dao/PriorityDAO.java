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

}
