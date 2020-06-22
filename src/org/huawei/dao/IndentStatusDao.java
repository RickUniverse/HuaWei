package org.huawei.dao;

import java.util.List;

import org.huawei.entity.IndentStatus;

/**
 * ����״̬�ӿ�
 * @author Administrator
 *
 */
public interface IndentStatusDao {
	/**
	 * ���ݶ���״̬id��ѯ״̬
	 * @param IndentStatusId
	 * @return
	 */
	IndentStatus selectIndentStatusByIndentStatusId(int IndentStatusId);
	/**
	 * ��ѯ��������idΪ    1  ������״̬
	 * 
	 * �û�idΪ���жϸ��û��Ķ����ֱ�ӵ�м������͵�״̬����
	 * @return
	 */
	List<IndentStatus> selectIndentStatusByAll(int hUserId);
	/**
	 * ����״̬id���û�id��ѯ���û�ӵ�и�״̬�Ķ���������
	 * @param hUserId
	 * @param IndentStatusId
	 * @return
	 */
	int getCountByHUserIdAndStatusId(int hUserId,int IndentStatusId);
	/**
	 * ��ѯ����״̬
	 * @return
	 */
	List<IndentStatus> selectIndentStatus();
}
