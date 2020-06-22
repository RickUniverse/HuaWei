package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ComboCommodity;

/**
 * 套餐内商品接口
 * @author Administrator
 *
 */
public interface ComboCommodityDao {
	/**
	 * 分页套餐中商品
	 * @param comboName
	 * @param commodityName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ComboCommodity> selectAllComboByComboId(String comboName , String commodityName , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String comboName , String commodityName);
	/**
	 * 添加套餐内商品
	 * @param comboId
	 * @param commodityId
	 * @return
	 */
	boolean addComboCommodity(int comboId,int commodityId);
	/**
	 * 删除
	 * @param ComboCommodityId
	 * @return
	 */
	boolean removeComboCommodity(int comboCommodityId);
}
