package org.xianghao.eshop.auth.mapper;

import org.apache.ibatis.annotations.*;
import org.xianghao.eshop.auth.domain.PriorityDO;

import java.util.List;

@Mapper
public interface PriorityMapper {
    /**
     * 查询根权限
     * @return 跟权限集合
     * */
    @Select("SELECT "
            + "id,"
            + "code,"
            + "url,"
            + "priority_comment,"
            + "priority_type,"
            + "parent_id,"
            + "gmt_create,"
            + "gmt_modified "
            + "FROM auth_priority "
            + "WHERE parent_id IS NULL")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<PriorityDO> listRootPriorities();


    /**
     * 根据父权限id查询子权限
     * @param parentId
     * @return 子权限
     * */
    @Select("SELECT " +
            "id,code,url,priority_comment,priority_type,parent_id,gmt_create,gmt_modified " +
            "FROM auth_priority" +
            "WHERE parent_id = #{parentId}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<PriorityDO> listChildPriorities(@Param("parentId") Long parentId);

}
