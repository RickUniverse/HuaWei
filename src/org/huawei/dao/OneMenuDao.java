package org.huawei.dao;

import java.util.List;

import org.huawei.entity.OneMenu;

/**
 * һ���˵��ӿ�
 * @author Administrator
 *
 */
public interface OneMenuDao {
	/**
	 * ��������һ���˵�
	 * @return
	 */
	List<OneMenu> selectOneMenuByAll();
	/**
	 * ����one�˵�
	 * @param id
	 * @return
	 */
	OneMenu selectOneMenuById(int id);
}
