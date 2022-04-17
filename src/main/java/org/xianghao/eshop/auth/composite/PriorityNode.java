package org.xianghao.eshop.auth.composite;

import org.xianghao.eshop.auth.visitor.impl.PriorityNodeVisitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriorityNode {
    /**
     * id
     */
    private Long id;
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限URL
     */
    private String url;
    /**
     * 权限类型
     */
    private Integer priorityType;
    //    /**
//     * 权限comment
//     * */
    private String priorityComment;
    /**
     * 父权限ID
     */
    private Long parentId;
    /**
     * 权限创建时间
     */
    private Date gmtCreate;
    /**
     * 权限修改时间
     */
    private Date gmtModified;
    /**
     * 子权限节点
     */
    private List<PriorityNode> children = new ArrayList<PriorityNode>();



    /**
     * 接收一个权限树访问者
     *
     * @param visitor
     */
    public void accept(PriorityNodeVisitor visitor) {
        visitor.visit(this);
    }

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

    public Integer getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(Integer priorityType) {
        this.priorityType = priorityType;
    }

    public String getPriorityComment() {
        return priorityComment;
    }

    public void setPriorityComment(String priorityComment) {
        this.priorityComment = priorityComment;
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

    public List<PriorityNode> getChildren() {
        return children;
    }

    public void setChildren(List<PriorityNode> children) {
        this.children = children;
    }


}
