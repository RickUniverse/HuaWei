package org.huawei.dao;

import java.util.List;

import org.huawei.entity.IndentDetail;

/**
 * ������ϸ�ӿ�
 * @author Administrator
 *
 */
public interface IndentDetailDao {
	/**
	 * \���ݶ���id��ѯ�ö�����������ϸ������Ϣ
	 * @param indentId
	 * @return
	 */
	List<IndentDetail> selectIndentDetailByIndentId(int indentId);
	/**
	 * �����ϸ����
	 * @param i
	 * @return
	 */
	boolean addIndentDetail(IndentDetail i);
}
