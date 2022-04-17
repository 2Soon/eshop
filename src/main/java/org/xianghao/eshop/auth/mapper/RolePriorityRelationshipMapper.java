package org.xianghao.eshop.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 角色和权限之间的关系管理模块的mapper组件
 * */
@Mapper
public interface RolePriorityRelationshipMapper {
    /**
     * 根据权限ID 查询记录数
     * 权限ID
     * 记录数
     * */
    @Select("SELECT count(*) FROM auth_role_priority_relationship WHERE priority_id=#{priorityId}")
    Long getCountByPriorityId(@Param("priorityId") Long priorityId);

}
