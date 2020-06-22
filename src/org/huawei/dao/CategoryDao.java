package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Category;

/**
 * 种类接口
 * @author Administrator
 *
 */
public interface CategoryDao {
	/**
	 * 获得种类对象
	 * @param id
	 * @return
	 */
	Category selectCategoryById(int categoryid);
	/**
	 * 根据细分查询
	 * @param seriesId
	 * @return
	 */
	Category selectCategoryBySeriesId(int seriesId);
	/**
	 * 查询出所有分类
	 * @return
	 */
	List<Category> selectAllCategory();
	/**
	 * 查询出所有分类
	 * @return
	 */
	List<Category> selectAllCategory(String sName  , int pageNo , int pageSize);
	/**
	 * 获取总条数
	 * @return
	 */
	int getTotalCount(String sName);
	/**
	 * 添加种类
	 * @param category
	 * @return
	 */
	boolean addCategory(Category category);
	/**
	 * 根据种类id删除种类
	 * @param categoryId
	 * @return
	 */
	boolean deleteCategoryByCategoryId(int categoryId);
}
