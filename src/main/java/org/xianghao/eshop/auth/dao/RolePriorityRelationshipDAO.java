package org.xianghao.eshop.auth.dao;

/**
 * 角色和权限关系模块的DAO组件接口
 * */
public interface RolePriorityRelationshipDAO {
    /**
     * 根据权限ID 查询记录数
     * @param priorityId 权限ID
     * @return  记录数
     * */
    Long getCountByPriorityId(Long priorityId);

}
