package org.xianghao.eshop.cart.dao;


import org.xianghao.eshop.cart.domain.ShoppingCartDO;

/**
 * 购物车管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface ShoppingCartDAO {

	/**
	 * 根据用户账号id查询购物车
	 * @param userAccountId 用户账号id
	 * @return 购物车
	 */
	ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId);
	
	/**
	 * 新增购物车
	 * @param shoppingCartDO 购物车DO对象
	 */
	Long saveShoppingCart(ShoppingCartDO shoppingCartDO);
	
}
