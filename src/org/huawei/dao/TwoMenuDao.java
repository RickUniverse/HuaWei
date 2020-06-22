package org.huawei.dao;


import java.util.List;

import org.huawei.entity.TwoMenu;

/**
 * 获得二级菜单
 * @author Administrator
 *
 */
public interface TwoMenuDao {
	/**
	 * 根据id获取二级菜单集合
	 * @param id
	 * @return
	 */
	List<TwoMenu> selectTwoMenuById(int onemenuid);
	
	TwoMenu selectOneTwoMenuById(int onemenuid);
}
