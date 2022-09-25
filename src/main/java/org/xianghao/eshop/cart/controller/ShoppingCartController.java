package org.xianghao.eshop.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xianghao.eshop.cart.service.ShoppingCartService;


/**
 * 购物车管理模块的controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	/**
	 * 购物车管理模块的service组件
	 */
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	/**
	 * 添加购物车商品条目
	 * @param userAccountId 用户账号id
	 * @param goodsSkuId 商品sku id
	 * @return 处理结果
	 */
	@PostMapping("/item/add") 
	public Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId) {
		try {
			return shoppingCartService.addShoppingCartItem(userAccountId, goodsSkuId);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return false;
	}
	
}
