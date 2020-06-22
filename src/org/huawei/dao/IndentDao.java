package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Indent;

/**
 * ����ʵ�ֽӿ�
 * @author Administrator
 *
 */
public interface IndentDao {
	/**
	 * �����û�id�Ͷ���״̬��ѯ��������
	 * @param huserId
	 * @return
	 */
	Indent selectIndentByhuserIdAndstatusId(int huserId , int statusId);
	/**
	 * ���һ������
	 * @param indent
	 * @return
	 */
	boolean addIndent(Indent i);
	/**
	 * ���ն���id�޸Ķ���״̬
	 * @param indentId
	 * @return
	 */
	boolean updateIndentStatusByIndentId(int indentId, int statusId);
	/**
	 * ���ݶ���id��ѯ����
	 * @param indentId
	 * @return
	 */
	Indent selectIndentByIndentId(int indentId);
	/**
	 * ���ն���id�޸Ķ���
	 * @param indentId
	 * @return
	 */
	boolean updateIndentByIndentId(int indentId , int addressId, int integral, double payment, int Stateid);
	/**
	 * �����û�id��ѯ�����иö���
	 * @param huserId
	 * @param statusId����״̬
	 * @param pageNo��ǰҳ��
	 * @param pageSizeÿҳ����
	 * @return
	 */
	List<Indent> selectIndentByHUserId(int huserId , int statusId , int pageNo , int pageSize);
	/**
	 * �����û�id��״̬id��ȡ������
	 * @param huserId
	 * @param statusId
	 * @return
	 */
	int getTotalCountByHUserIdAndStatusId(int huserId , int statusId);
	/**
	 * ����indentId�޸Ķ�����ѡ��״̬
	 * @param hUserId
	 * @return
	 */
	boolean updateCheckedByindentId(int indentId,boolean isChecked);
	/**
	 * ���ݶ������id��ѯ����
	 * sql   ���ʹ��           in     �ؼ���
	 * @param togoIntendId
	 * @return
	 */
	List<Indent> selectIndentByTogoIndentId(String togoIntendId);
	/**
	 * ���ݿ�ʹ��     in �ؼ����޸Ķ���״̬
	 * @param indentId
	 * @param statusId
	 * @return
	 */
	boolean updateIndentStatusByIndentId(String indentIds, int statusId);
	/**
	 * ��̨��ҳ
	 * @param indentId
	 * @param statusId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Indent> selectAllIndent(int indentId , int statusId , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(int indentId , int statusId);
}
