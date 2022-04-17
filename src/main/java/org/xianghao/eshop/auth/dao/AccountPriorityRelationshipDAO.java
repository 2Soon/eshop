package org.xianghao.eshop.auth.dao;

/**
 * 账号和权限关系管理模块的mapper组件
 * */
public interface AccountPriorityRelationshipDAO {
    /**
     * 根据权限ID 查询记录数
     * @param priorityId 权限ID
     * @return  记录数
     * */
    Long getCountByPriorityId(Long priorityId);

}
