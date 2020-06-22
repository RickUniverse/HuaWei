package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Combo;

/**
 * 套餐接口
 * @author Administrator
 *
 */
public interface ComboDao {
	/**
	 * 获取商品所拥有的所有套餐，根据商品id
	 * @param commodityId
	 * @return
	 */
	List<Combo> selectComboByCommodityId(int commodityId);
	/**
	 * 根据套餐id获取一个套餐对象
	 * @param comboId
	 * @return
	 */
	Combo selectOneComboByComboId(int comboId);
	/**
	 * 后台分页查询套餐
	 * @param comboName
	 * @param commodityName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Combo> selectAllComboByComboName(String comboName , String commodityName , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String comboName , String commodityName);
	/**
	 * 添加combo套餐
	 * @param c
	 * @return
	 */
	boolean addCombo(Combo c);
	/**
	 * 删除套餐
	 * @param comboId
	 * @return
	 */
	boolean deleteCombo(int comboId);
	
}
