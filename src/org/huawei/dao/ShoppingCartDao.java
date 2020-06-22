package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ShoppingCart;

/**
 * 购物车接口
 * @author Administrator
 *
 */
public interface ShoppingCartDao {
	/**
	 * 添加商品到购物车
	 * @param colorAndConfigureId 颜色跟配置id
	 * @param total 数量
	 * @param totalPrice 价格
	 * @param comboId 套餐id
	 * @param huserid 用户id
	 * @return
	 */
	boolean addShoppingCart(int colorAndConfigureId , int total , double totalPrice , int comboId , int huserid);
	/**
	 * 根据用户id查询出所有购物车内商品
	 * @param hUserId
	 * @return
	 */
	List<ShoppingCart> selectAllShoppingCartByUserId(int hUserId);
	/**
	 * 按照用户id查询出该用户选中商品的总价格
	 * @param HUserId
	 * @return
	 */
	double selectTotalPrice(int HUserId);
	/**
	 * 按照用户id查询出该用户所有选中的商品
	 * @param HUserId
	 * @return
	 */
	int selectTotalCheck(int HUserId);
	/**
	 * 按照用户id查询出该用户选中商品优惠的总价格
	 * @param HUserId
	 * @return
	 */
	double selectYouPrice(int HUserId);
	/**
	 * 按照购物车id，修改选中状态
	 * @param shoppingCartId
	 * @param isChecked//false为未选中，true为选中
	 * @return
	 */
	boolean updateShoppingCartCheckedByShoppingCartId(int shoppingCartId , boolean isChecked);
	/**
	 * 按照用户id修改用户对应的商品的所有checked
	 * @param hUserId
	 * @param isChecked
	 * @return
	 */
	boolean updateShoppingCartCheckedByHUserId(int hUserId , boolean isChecked);
	/**
	 * 根据购物车id删除对应商品
	 * @param shoppingCartId
	 * @return
	 */
	boolean deleteShoppingCartByShoppingCartId(int shoppingCartId);
	/**
	 * 根据商品id加减
	 * 返回修改后的对象
	 * @param shoppingCartId
	 * @param issubstartAndAdd ture : ++       false : --
	 * @return
	 */
	ShoppingCart updateNumberByShoppingCartId(boolean issubstartAndAdd , int shoppingCartId);
	/**
	 * 根据购物车id查询
	 * @param shoppingCartId
	 * @return
	 */
	ShoppingCart selectOneShoppingCartByShoppingCartId(int shoppingCartId);
	/**
	 * 按照用户id查询选中商品的数量
	 * @param huserId
	 * @return
	 */
	int getCheckedShoppingCartTotalByHUserId(int huserId);
	/**
	 * 按照用户id查询出所有选中的商品
	 * @param huserId
	 * @return
	 */
	List<ShoppingCart> selectAllCheckedByHUserId(int huserId);
	/**
	 * 删除所有宣州的购物车
	 * @param hUserId
	 * @return
	 */
	boolean deleteAllChecked(int hUserId);
}
