package org.xianghao.eshop.auth.visitor.impl.impl;


import org.xianghao.eshop.auth.composite.PriorityNode;
import org.xianghao.eshop.auth.dao.AccountPriorityRelationshipDAO;
import org.xianghao.eshop.auth.dao.PriorityDAO;
import org.xianghao.eshop.auth.dao.RolePriorityRelationshipDAO;
import org.xianghao.eshop.auth.domain.PriorityDO;
import org.xianghao.eshop.auth.visitor.impl.PriorityNodeVisitor;

import java.util.List;

/**
 * 权限树节点的关联检查访问者
 */
public class PriorityNodeRelateCheckVisitor implements PriorityNodeVisitor {

    /**
     * 关联检查结果
     */
    private Boolean relateCheckResult;

    /**
     * 权限管理模块的DAO组件
     */
    private PriorityDAO priorityDAO;

    /**
     * 角色和权限关系管理模块的DAO组件
     */
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
    /**
     * 账号和权限关系管理模块的DAO组件
     */
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;


    /**
     * 构造函数
     *
     * @param priorityDAO 权限管理模块的DAO组件
     */
    public PriorityNodeRelateCheckVisitor(PriorityDAO priorityDAO,
                                          RolePriorityRelationshipDAO rolePriorityRelationshipDAO,
                                          AccountPriorityRelationshipDAO accountPriorityRelationshipDAO) {
        this.priorityDAO = priorityDAO;
        this.rolePriorityRelationshipDAO = rolePriorityRelationshipDAO;
        this.accountPriorityRelationshipDAO = accountPriorityRelationshipDAO;
    }

    /**
     * 访问权限树节点
     */
    @Override
    public void visit(PriorityNode node) {
        //遍历所有的子节点
        List<PriorityDO> priorityDOS = priorityDAO.listChildPriorities(node.getId());

        if (priorityDOS != null && priorityDOS.size() > 0) {
            for (PriorityDO priorityDO : priorityDOS) {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                //递归处理下级子节点
                priorityNode.accept(this);
            }
        }
        //检查权限是否被任何一个角色或是账号关联了
        if (relateCheck(node)) {
            this.relateCheckResult = true;
        }

    }

    /**
     * 检查权限是否被任何一个角色或是账号关联了
     *
     * @param node 权限树节点
     * @return 是否被任何一个角色或者是账号关联了，如果有关联则为false
     */
    private Boolean relateCheck(PriorityNode node) {
        Long roleRelatedCount = rolePriorityRelationshipDAO.getCountByPriorityId(node.getId());
        if (roleRelatedCount != null && roleRelatedCount > 0) {
            return true;
        }
        Long accountRelatedCount = accountPriorityRelationshipDAO.getCountByPriorityId(node.getId());
        if (accountRelatedCount != null && accountRelatedCount > 0) {
            return true;
        }

        return false;
    }

    public Boolean getRelateCheckResult() {
        return relateCheckResult;
    }
}
