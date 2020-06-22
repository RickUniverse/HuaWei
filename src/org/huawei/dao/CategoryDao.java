package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Category;

/**
 * ����ӿ�
 * @author Administrator
 *
 */
public interface CategoryDao {
	/**
	 * ����������
	 * @param id
	 * @return
	 */
	Category selectCategoryById(int categoryid);
	/**
	 * ����ϸ�ֲ�ѯ
	 * @param seriesId
	 * @return
	 */
	Category selectCategoryBySeriesId(int seriesId);
	/**
	 * ��ѯ�����з���
	 * @return
	 */
	List<Category> selectAllCategory();
	/**
	 * ��ѯ�����з���
	 * @return
	 */
	List<Category> selectAllCategory(String sName  , int pageNo , int pageSize);
	/**
	 * ��ȡ������
	 * @return
	 */
	int getTotalCount(String sName);
	/**
	 * �������
	 * @param category
	 * @return
	 */
	boolean addCategory(Category category);
	/**
	 * ��������idɾ������
	 * @param categoryId
	 * @return
	 */
	boolean deleteCategoryByCategoryId(int categoryId);
}
