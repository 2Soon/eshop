package org.xianghao.eshop.auth.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.xianghao.eshop.auth.dao.AccountPriorityRelationshipDAO;
import org.xianghao.eshop.auth.mapper.AccountPriorityRelationshipMapper;

public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {

    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;

    /**
     * 根据权限ID 查询记录数
     * @param priorityId 权限ID
     * @return  记录数
     * */
    @Override
    public Long getCountByPriorityId(Long priorityId) {
        return accountPriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }
}
