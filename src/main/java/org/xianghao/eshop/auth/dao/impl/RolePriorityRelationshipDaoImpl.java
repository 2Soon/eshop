package org.xianghao.eshop.auth.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xianghao.eshop.auth.dao.RolePriorityRelationshipDAO;
import org.xianghao.eshop.auth.mapper.RolePriorityRelationshipMapper;

@Repository
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
