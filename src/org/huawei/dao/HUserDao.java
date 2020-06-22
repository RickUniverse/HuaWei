package org.huawei.dao;

import java.util.List;

import org.huawei.entity.HUser;

/**
 * ��Ϊ�û��ӿ�
 * @author Administrator
 *
 */
public interface HUserDao {
	/**
	 * ����huserid��ѯ����Ϊ�û�
	 * @param huserid
	 * @return
	 */
	HUser selectHUserById(int huserid);
	/**
	 * �����û�id�޸ĸ��û���Ĭ�ϵ�ַ
	 * @param addressId
	 * @return
	 */
	boolean updateDefaultAddressByhuserid(int addressId,int huserid);
	/**
	 * ��̨�û������ȡ�����û�
	 * ���շ�ҳ
	 * @return
	 */
	List<HUser> selectAllHUser(int pageNo , int pageSize);
	/**
	 * ��ȡ�����û�������
	 * @return
	 */
	int totalCountHUser();
	/**
	 * �ҵĶ�������
	 * @return
	 */
	int totalIndent(int hUserId);
}
