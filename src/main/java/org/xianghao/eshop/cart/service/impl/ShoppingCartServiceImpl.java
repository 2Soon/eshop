package org.xianghao.eshop.cart.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xianghao.eshop.cart.dao.ShoppingCartDAO;
import org.xianghao.eshop.cart.dao.ShoppingCartItemDAO;
import org.xianghao.eshop.cart.domain.ShoppingCartDO;
import org.xianghao.eshop.cart.domain.ShoppingCartItemDO;
import org.xianghao.eshop.cart.service.ShoppingCartService;


/**
 * 购物车管理模块的service组件
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    /**
     * 购物车管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    /**
     * 购物车条目管理模块的DAO组件
     */
    @Autowired
    private ShoppingCartItemDAO shoppingCartItemDAO;

    /**
     * 添加购物车商品条目
     *
     * @param userAccountId 用户账号id
     * @param goodsSkuId    商品sku id
     * @return 处理结果
     */
    public Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId) {
        try {
            // 先查询一下用户的购物车
            ShoppingCartDO shoppingCartDO = shoppingCartDAO
                    .getShoppingCartByUserAccountId(userAccountId);

            // 如果购物车不存在，则新增一个购物车
            if (shoppingCartDO == null) {
                shoppingCartDO = new ShoppingCartDO();
                shoppingCartDO.setUserAccountId(userAccountId);
                shoppingCartDO.setGmtCreate(new Date());
                shoppingCartDO.setGmtModified(new Date());

                shoppingCartDAO.saveShoppingCart(shoppingCartDO);
            }


            // 查询一下购物车中是否存在这个商品sku对应的条目
            ShoppingCartItemDO shoppingCartItemDO = shoppingCartItemDAO
                    .getShoppingCartItemByGoodsSkuId(shoppingCartDO.getId(), goodsSkuId);

            // 如果没有这个商品条目，则新增一个商品条目
            if (shoppingCartItemDO == null) {
                shoppingCartItemDO = new ShoppingCartItemDO();
                shoppingCartItemDO.setShoppingCartId(shoppingCartDO.getId());
                shoppingCartItemDO.setGoodsSkuId(goodsSkuId);
                shoppingCartItemDO.setPurchaseQuantity(1L);
                shoppingCartItemDO.setGmtCreate(new Date());
                shoppingCartItemDO.setGmtModified(new Date());

                shoppingCartItemDAO.saveShoppingCartItem(shoppingCartItemDO);
            }
            // 如果购物车中已经存在这个商品条目了，则对已有的商品条目的购买数量累加1
            else {
                shoppingCartItemDO.setPurchaseQuantity(
                        shoppingCartItemDO.getPurchaseQuantity() + 1L);
                shoppingCartItemDO.setGmtModified(new Date());
                shoppingCartItemDAO.updateShoppingCartItem(shoppingCartItemDO);
            }
        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
        return true;
    }

}
