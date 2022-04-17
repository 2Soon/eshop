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
            + "WHERE parent_id  = #{parentId}")
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
    List<PriorityDO> listChildPriorities(@Param("parentId") Long parentId);

    /**
     * 新增权限
     *
     * @param priorityDO 权限DO对象
     */
    @Insert("INSERT INTO auth_priority(code,url,priority_comment,priority_type,parent_id,gmt_create,gmt_modified)" +
            "VALUES(#{code},#{url},#{priorityComment},#{priorityType},#{parentId},#{gmtCreate},#{gmtModified})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void savePriority(PriorityDO priorityDO);

    /**
     * 更新权限
     *
     * @param priorityDO 权限DO对象
     */
    @Update("UPDATE auth_priority SET " +
            "code=#{code}," +
            "url=#{url}," +
            "priority_comment=#{priorityComment}," +
            "priority_type=#{priorityType}," +
            "parent_id=#{parentId}," +
            "gmt_create=#{gmtCreate}," +
            "gmt_modified=#{gmtModified}" +
            "WHERE id = #{id}")
    void updatePriority(PriorityDO priorityDO);

    /**
     * 删除权限
     * */
    @Delete("DELETE FROM auth auth_priority WHERE id = #{id}")
    void removePriority(@Param("id") Long id);
}
