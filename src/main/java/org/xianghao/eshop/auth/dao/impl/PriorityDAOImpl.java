package org.xianghao.eshop.auth.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xianghao.eshop.auth.dao.PriorityDAO;
import org.xianghao.eshop.auth.domain.PriorityDO;
import org.xianghao.eshop.auth.mapper.PriorityMapper;
import org.xianghao.eshop.auth.service.impl.PriorityServiceImpl;

import java.util.List;

/**
 * 权限管理模块DAO组件
 * */
@Repository
public class PriorityDAOImpl implements PriorityDAO {
    private static final Logger logger = LoggerFactory.getLogger(PriorityServiceImpl.class);


    @Autowired
    private PriorityMapper priorityMapper;


    /**
     * 查询根权限列表
     * */
    @Override
    public List<PriorityDO> listRootPriorities() {
        try {
            return priorityMapper.listRootPriorities();
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 根据父权限查询子权限
     * @param parentId 父权限
     * @return 子权限
     * */
    @Override
    public List<PriorityDO> listChildPriorities(Long parentId) {
        try {
            return priorityMapper.listChildPriorities(parentId);

        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 根据ID查询
     * @param id
     * @return PriorityDO权限DO
     * */
    @Override
    public PriorityDO getPriorityById(Long id) {
        try {
            return priorityMapper.getPriorityById(id);
        }catch (Exception e){
            logger.error("error",e);
        }
        return null;
    }

    /**
     * 新增权限
     *
     * @param priorityDO 权限DO对象
     */
    @Override
    public Boolean savePriority(PriorityDO priorityDO) {
        try {
            priorityMapper.savePriority(priorityDO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     *
     * @param priorityDO 权限DO对象
     */
    @Override
    public Boolean updatePriority(PriorityDO priorityDO) {
        try {
            priorityMapper.updatePriority(priorityDO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

    /**
     * 删除权限
     * @param id
     * */
    @Override
    public Boolean removePriority(Long id) {
        try {
            priorityMapper.removePriority(id);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }

}
