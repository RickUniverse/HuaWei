package org.huawei.dao;

import org.huawei.entity.Admin;
/**
 * ����Ա�ӿ�
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * ��¼�����ع���Ա����
	 * @param aName
	 * @param password
	 * @return
	 */
	Admin loginByANameAndPassword(String aName , String password);
	/**
	 * ͳ����Ʒ����
	 */
	int getComodityTotal();
	/**
	 * ͳ����Ʒ��������
	 */
	int getCategoryTotal();
	/**
	 * ͳ����Ʒϸ������
	 */
	int getSeriesTotal();
	/**
	 * ͳ�ƶ�������
	 */
	int getIndentTotal();
	/**
	 * ͳ���û�����
	 */
	int getHUserTotal();
	/**
	 * ͳ����Ӫҵ��
	 */
	long getTotalPrice();
}
