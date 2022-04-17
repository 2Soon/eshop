package org.xianghao.eshop.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.auth.composite.PriorityNode;
import org.xianghao.eshop.auth.dao.AccountPriorityRelationshipDAO;
import org.xianghao.eshop.auth.dao.PriorityDAO;
import org.xianghao.eshop.auth.dao.RolePriorityRelationshipDAO;
import org.xianghao.eshop.auth.domain.PriorityDO;
import org.xianghao.eshop.auth.domain.PriorityDTO;
import org.xianghao.eshop.auth.service.PriorityService;
import org.xianghao.eshop.auth.visitor.impl.impl.PriorityNodeRelateCheckVisitor;
import org.xianghao.eshop.auth.visitor.impl.impl.PriorityNodeRemoveVisitor;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理的service组件
 */
@Service
public class PriorityServiceImpl implements PriorityService {
    private static final Logger logger = LoggerFactory.getLogger(PriorityServiceImpl.class);

    /**
     * 权限管理模块的DAO组件
     */
    @Autowired
    private PriorityDAO priorityDAO;
    /**
     *角色和权限关系模块的DAO组件
     * */
    @Autowired
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
    /**
     * 账号和权限关系管理模块的DAO组件
     * */
    @Autowired
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;



    /**
     * 查询根权限
     *
     * @Return 根权限集合
     */
    @Override
    public List<PriorityDTO> listRootPriorities() {
        try {
            List<PriorityDO> priorityDOS = priorityDAO.listRootPriorities();
            if (priorityDOS == null) {
                return null;
            }
            //arrayList 新建时，传入size大小
            List<PriorityDTO> priorityDTOS = new ArrayList<PriorityDTO>(priorityDOS.size());
            for (PriorityDO priorityDO : priorityDOS) {
                priorityDTOS.add(priorityDO.clone(PriorityDTO.class));
            }
            return priorityDTOS;


        } catch (Exception e) {
            logger.error("error", e);
        }
        return null;
    }

    /**
     * 根据父权限id查询子权限
     *
     * @param parentId
     * @return 子权限dd
     */
    @Override
    public List<PriorityDTO> listChildPriorities(Long parentId) {
        try {
            List<PriorityDO> priorityDOS = priorityDAO.listChildPriorities(parentId);
            if (priorityDOS == null) {
                return null;
            }
            ArrayList<PriorityDTO> priorityDTOS = new ArrayList<PriorityDTO>(priorityDOS.size());
            for (PriorityDO priorityDO : priorityDOS) {
                priorityDTOS.add(priorityDO.clone(PriorityDTO.class));
            }
            return priorityDTOS;

        } catch (Exception e) {
            logger.error("error", e);
        }
        return null;
    }

    /**
     * 根据ID查询
     */
    @Override
    public PriorityDTO getPriorityById(Long id) {
        try {
            PriorityDO priorityDO = priorityDAO.getPriorityById(id);
            if (priorityDO == null) {
                return null;
            }
            return priorityDO.clone(PriorityDTO.class);
        } catch (Exception e) {
            logger.error("error", e);
        }
        return null;
    }

    /**
     * 新增权限
     *
     * @param priorityDTO 权限DO对象
     */
    @Override
    public Boolean savePriority(PriorityDTO priorityDTO) {
        try {
            priorityDAO.savePriority(priorityDTO.clone(PriorityDO.class));
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     *
     * @param priorityDTO 权限DO对象
     */
    @Override
    public Boolean updatePriority(PriorityDTO priorityDTO) {
        try {
            priorityDAO.updatePriority(priorityDTO.clone(PriorityDO.class));
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 删除权限
     * */
    /**
     * 删除权限
     */
    @Override
    public Boolean removePriority(Long id) {
        try {
            //根据id查询权限
            PriorityDO priorityDO = priorityDAO.getPriorityById(id);
            PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
            //检查这个权限以及其下任何一个权限，是否被角色或者账号给关联着
            PriorityNodeRelateCheckVisitor relateCheckVisitor = new PriorityNodeRelateCheckVisitor(
                    priorityDAO, rolePriorityRelationshipDAO, accountPriorityRelationshipDAO);
            relateCheckVisitor.visit(priorityNode);
            Boolean relateCheckResult = relateCheckVisitor.getRelateCheckResult();
            if (relateCheckResult) {
                return false;
            }
            //递归删除当前权限以及其下所有子权限
            PriorityNodeRemoveVisitor removeVisitor = new PriorityNodeRemoveVisitor(priorityDAO);
            removeVisitor.visit(priorityNode);
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }
}

