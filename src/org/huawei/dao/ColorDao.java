package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Color;

/**
 * 颜色接口
 * @author Administrator
 *
 */
public interface ColorDao {
	/**
	 * 获取颜色对象
	 * 根据id
	 * @param id
	 * @return
	 */
	Color selectColorById(int id);
	/**
	 * 根据商品名查询出拥有的颜色集合
	 * @param commodityId
	 * 这个配置id用来判断这个颜色中是否包含该配置，有为true 无为 false
	 * @param configureId
	 * @return
	 */
	List<Color> selectColorByCommodityId(int commodityId , int configureId);
	/**
	 * 跟上面的方法合用
	 */
	boolean isExisitByConfigureId(int commodityId , int colorId ,int configureId);
	/**
	 * 分页查询
	 * @param cName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Color> selectAllColorBycName(String cName , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String cName);
	/**
	 * 添加颜色
	 * @param cName
	 * @return
	 */
	boolean addColor(String cName);
	/**
	 * 删除颜色
	 * @param colorId
	 * @return
	 */
	boolean deleteColor(int colorId);
	/**
	 * 全部颜色
	 * @return
	 */
	List<Color> selectAllColorBycName();
}
