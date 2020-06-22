package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ComboCommodity;

/**
 * �ײ�����Ʒ�ӿ�
 * @author Administrator
 *
 */
public interface ComboCommodityDao {
	/**
	 * ��ҳ�ײ�����Ʒ
	 * @param comboName
	 * @param commodityName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ComboCommodity> selectAllComboByComboId(String comboName , String commodityName , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String comboName , String commodityName);
	/**
	 * ����ײ�����Ʒ
	 * @param comboId
	 * @param commodityId
	 * @return
	 */
	boolean addComboCommodity(int comboId,int commodityId);
	/**
	 * ɾ��
	 * @param ComboCommodityId
	 * @return
	 */
	boolean removeComboCommodity(int comboCommodityId);
}
