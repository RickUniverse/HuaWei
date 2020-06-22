package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Combo;

/**
 * �ײͽӿ�
 * @author Administrator
 *
 */
public interface ComboDao {
	/**
	 * ��ȡ��Ʒ��ӵ�е������ײͣ�������Ʒid
	 * @param commodityId
	 * @return
	 */
	List<Combo> selectComboByCommodityId(int commodityId);
	/**
	 * �����ײ�id��ȡһ���ײͶ���
	 * @param comboId
	 * @return
	 */
	Combo selectOneComboByComboId(int comboId);
	/**
	 * ��̨��ҳ��ѯ�ײ�
	 * @param comboName
	 * @param commodityName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Combo> selectAllComboByComboName(String comboName , String commodityName , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String comboName , String commodityName);
	/**
	 * ���combo�ײ�
	 * @param c
	 * @return
	 */
	boolean addCombo(Combo c);
	/**
	 * ɾ���ײ�
	 * @param comboId
	 * @return
	 */
	boolean deleteCombo(int comboId);
	
}
