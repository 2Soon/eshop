package org.xianghao.eshop.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.auth.dao.PriorityDAO;
import org.xianghao.eshop.auth.domain.PriorityDO;
import org.xianghao.eshop.auth.domain.PriorityDTO;
import org.xianghao.eshop.auth.service.PriorityService;

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
}
