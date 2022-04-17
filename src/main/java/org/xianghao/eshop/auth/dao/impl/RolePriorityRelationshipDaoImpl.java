package org.xianghao.eshop.auth.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.xianghao.eshop.auth.dao.RolePriorityRelationshipDAO;
import org.xianghao.eshop.auth.mapper.RolePriorityRelationshipMapper;

public class RolePriorityRelationshipDaoImpl implements RolePriorityRelationshipDAO {
    /**
     *
     * */
    @Autowired
    private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    @Override
    public Long getCountByPriorityId(Long priorityId) {

        return rolePriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }
}
