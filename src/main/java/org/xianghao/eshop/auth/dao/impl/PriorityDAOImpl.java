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

        return null;
    }

}
