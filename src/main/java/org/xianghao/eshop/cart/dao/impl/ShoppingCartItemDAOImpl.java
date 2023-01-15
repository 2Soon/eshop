package org.xianghao.eshop.cart.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xianghao.eshop.cart.dao.ShoppingCartItemDAO;
import org.xianghao.eshop.cart.domain.ShoppingCartItemDO;
import org.xianghao.eshop.cart.mapper.ShoppingCartItemMapper;

import java.util.List;


/**
 * 购物车条目管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDAOImpl.class);

	/**
	 * 购物车条目管理模块的mapper组件
	 */
	@Autowired
	private ShoppingCartItemMapper shoppingCartItemMapper;
	
	/**
	 * 新增购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Override
	public Boolean saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {
		try {
			shoppingCartItemMapper.saveShoppingCartItem(shoppingCartItemDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 根据商品sku id查询购物车中是否存在商品条目
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @return 商品条目
	 */
	@Override
	public ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
			Long shoppingCartId,Long goodsSkuId) {
		try {
			return shoppingCartItemMapper.getShoppingCartItemByGoodsSkuId(
					shoppingCartId, goodsSkuId);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
	/**
	 * 更新购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Override
	public Boolean updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {
		try {
			shoppingCartItemMapper.updateShoppingCartItem(shoppingCartItemDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}

	/**
	 * 查询购物车中的所有条目
	 * @param shoppingCartId 购物车id
	 * @return 商品条目
	 */
	@Override
	public List<ShoppingCartItemDO> listShoppingCartItemByCartId(Long shoppingCartId) throws Exception {
		return shoppingCartItemMapper.listShoppingCartItemByCartId(shoppingCartId);
	}

	/**
	 * 删除购物车条目
	 * @param id 购物车条目id
	 */
	@Override
	public void remove(Long id) throws Exception {
		shoppingCartItemMapper.remove(id);
	}

}
