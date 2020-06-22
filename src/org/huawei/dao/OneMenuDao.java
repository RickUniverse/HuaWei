package org.huawei.dao;

import java.util.List;

import org.huawei.entity.OneMenu;

/**
 * 一级菜单接口
 * @author Administrator
 *
 */
public interface OneMenuDao {
	/**
	 * 返回所有一级菜单
	 * @return
	 */
	List<OneMenu> selectOneMenuByAll();
	/**
	 * 返回one菜单
	 * @param id
	 * @return
	 */
	OneMenu selectOneMenuById(int id);
}
