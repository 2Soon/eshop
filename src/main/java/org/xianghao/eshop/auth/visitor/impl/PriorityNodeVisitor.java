package org.xianghao.eshop.auth.visitor.impl;

import org.xianghao.eshop.auth.composite.PriorityNode;

/**
 * 权限树结点的访问者接口
 *
 * */
public interface PriorityNodeVisitor {

    /**
     * 访问权限树节点
     * */
    void visit(PriorityNode node);
}
