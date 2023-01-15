package org.xianghao.eshop.cart.dao;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.xianghao.eshop.cart.domain.ShoppingCartDO;

import java.util.Date;

/**
 * @description: 购物车管理模块的DAO组建的单元测试类
 * @packagename: org.xianghao.eshop.cart.dao
 * @author: XiangHao
 * @date: 2023-01-02 12:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class ShoppingCartDAOTest {

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    /**
     * 测试新增购物车
     * */
    @Test
    public void testSaveShoppingCart() throws Exception{
        Long userAccountId = 2L;
        Date currentTime = new Date();

        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(currentTime);
        shoppingCartDO.setGmtModified(currentTime);

        Long shoppingCartId = shoppingCartDAO.saveShoppingCart(shoppingCartDO);

        assertNotNull(shoppingCartId);
        assertThat(shoppingCartId,greaterThan(0L));

    }

    /**
     * 测试根据用户账号id查询购物车
     * */
    @Test
    public void testGetShoppingCartByUserAccountId() throws Exception{
        //构造购物车
        Long userAccountId = 3L;
        Date currentTime = new Date();

        ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(currentTime);
        shoppingCartDO.setGmtModified(currentTime);

        Long shoppingCartId = shoppingCartDAO.saveShoppingCart(shoppingCartDO);

        //查询
        ShoppingCartDO resultShoppingCartDO = shoppingCartDAO
                .getShoppingCartByUserAccountId(userAccountId);
        //断言结果
        assertEquals(shoppingCartDO,resultShoppingCartDO);

    }

}
