package org.xianghao.eshop.auth.visitor.impl.impl;



import org.xianghao.eshop.auth.composite.PriorityNode;
import org.xianghao.eshop.auth.dao.PriorityDAO;
import org.xianghao.eshop.auth.domain.PriorityDO;
import org.xianghao.eshop.auth.visitor.impl.PriorityNodeVisitor;

import java.util.List;

/**
 * 权限树节点的删除访问者
 * */
public class PriorityNodeRemoveVisitor implements PriorityNodeVisitor {

    /**
     * 权限管理模块的DAO组件
     * */
    private PriorityDAO priorityDAO;

    /**
     * 构造函数
     * */
    public  PriorityNodeRemoveVisitor(PriorityDAO priorityDAO){
        this.priorityDAO = priorityDAO;
    }

    /**
     * 访问权限树节点
     * @param node  权限树节点
     * */
    @Override
    public void visit(PriorityNode node) {
        List<PriorityDO> priorityDOS = priorityDAO.listChildPriorities(node.getId());

        if (priorityDOS != null && priorityDOS.size() > 0) {
            for (PriorityDO priorityDO : priorityDOS) {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                //递归处理下级子节点
                priorityNode.accept(this);
            }
        }
        removePriority(node);
    }

    /**
     * 删除权限
     * */
    private void removePriority(PriorityNode node){
        priorityDAO.removePriority(node.getId());
    }
}
