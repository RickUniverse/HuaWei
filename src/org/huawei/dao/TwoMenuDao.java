package org.huawei.dao;


import java.util.List;

import org.huawei.entity.TwoMenu;

/**
 * ��ö����˵�
 * @author Administrator
 *
 */
public interface TwoMenuDao {
	/**
	 * ����id��ȡ�����˵�����
	 * @param id
	 * @return
	 */
	List<TwoMenu> selectTwoMenuById(int onemenuid);
	
	TwoMenu selectOneTwoMenuById(int onemenuid);
}
