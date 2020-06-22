package org.huawei.dao;

import org.huawei.entity.Admin;
/**
 * 管理员接口
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * 登录并返回管理员对象
	 * @param aName
	 * @param password
	 * @return
	 */
	Admin loginByANameAndPassword(String aName , String password);
	/**
	 * 统计商品数量
	 */
	int getComodityTotal();
	/**
	 * 统计商品种类数量
	 */
	int getCategoryTotal();
	/**
	 * 统计商品细分数量
	 */
	int getSeriesTotal();
	/**
	 * 统计订单数量
	 */
	int getIndentTotal();
	/**
	 * 统计用户数量
	 */
	int getHUserTotal();
	/**
	 * 统计总营业额
	 */
	long getTotalPrice();
}
