package org.xianghao.eshop.auth.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xianghao.eshop.common.util.BeanCopierUtils;

import java.util.Date;

/**
 * 权限DTO类
 * */
public class PriorityDTO {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDO.class);

    /**
     * id
     * */
    private Long id;
    /**
     * 权限编号
     * */
    private String code;
    /**
     * 权限URL
     * */
    private String url;
    /**
     * 权限类型
     * */
    private Integer priorityType;
    /**
     * 权限权限说明备注
     * */
    private String priorityComment;
    /**
     * 父权限ID
     * */
    private Long parentId;
    /**
     * 权限创建时间
     * */
    private Date gmtCreate;
    /**
     * 权限修改时间
     * */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriorityTye() {
        return priorityType;
    }

    public void setPriorityTye(Integer priorityTye) {
        this.priorityType = priorityTye;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPriorityComment() {
        return priorityComment;
    }

    public void setPriorityComment(String priorityComment) {
        this.priorityComment = priorityComment;
    }

    /**
     * 克隆方法
     * @param clazz 目标 class对象
     * @return 克隆后的对象
     * */
    public <T> T clone(Class<T> clazz){
        T target = null;
        try {
            target = clazz.newInstance();
        }catch (Exception e){
            logger.error("克隆对象的时候出错"+e);
        }

        BeanCopierUtils.copyProperties(this,target);
        return target;
    }
}
