package org.xianghao.eshop.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 账号和权限关系管理模块的mapper组件
 * */
@Mapper
public interface AccountPriorityRelationshipMapper {
    @Select("SELECT count(*) FROM auth_account_priority_relationship WHERE priority_id=#{priorityId}")
    Long getCountByPriorityId(@Param("priorityId") Long priorityId);
}
