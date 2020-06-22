package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Commodity;

/**
 * ��Ʒ��ʵ�ֽӿ�
 * @author Administrator
 *
 */
public interface CommodityDao {
	/**
	 * ��ȡ¥���ڵ���Ʒ����
	 * ��ҳ¥��
	 * @param floorId
	 * @return
	 */
	List<Commodity> selectCommodityByFloorId(int floorId);
	/**
	 * ������Ʒid��ѯ��Ʒ
	 * @param id
	 * @return
	 */
	Commodity selectCommodityById(int id);
	/**
	 * ������ɫ���ò�ѯ����Ӧ����Ʒ����
	 * ������ɫ����id��ѯ����Ӧ��Ʒ
	 * ��Ʒ����ҳ��
	 * @param colorandConfigureId
	 * @return
	 */
	Commodity selectCommodityByColorandConfigureId(int colorandConfigureId);
	/**
	 * �����ײ�id����ѯ�ײ�����Ʒ����
	 * �����ײ�id��ȡ�ײ��ڵ���Ʒ
	 * @param CommId
	 * @return
	 */
	List<Commodity> selectCommodityByCommId(int CommId);
	/**
	 * ��Ʒid����ָ����ѯ��һ����Ʒ�ڵ���ɫ����
	 * ������ɫid������id��ѯ����Ʒ����ɫ����
	 * @param commodityId//��Ʒid����ָ������һ����Ʒ
	 * @param colorId//�ж����ø���ɫ�Ĺ�ϵ
	 * @param configureId//�ж���ɫ�����õĹ�ϵ
	 * @param comboId//�������Ƶ�ǰ��Ʒѡ�е��ײ�
	 * @return
	 */
	Commodity selectCommodityByCommodityIdAndColorIdAndConfigureId(int commodityId , int colorId , int configureId , int comboId);
	/**
	 * ��ҳ��ѯ
	 * @param cName
	 * @param seriesId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Commodity> selectAllCommodityBycNameAndSeriesId(String cName,int seriesId,int pageNo,int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String cName,int seriesId);
	/**
	 * ���
	 * @param com
	 * @return
	 */
	boolean addCommodity(Commodity com);
	/**
	 * ɾ����Ʒ
	 * @param comId
	 * @return
	 */
	boolean deleteCommodityByComId(int comId);
	/**
	 * �޸�
	 * @return
	 */
	boolean updateCommodity(Commodity com);
	/**
	 * ��ѯ��������Ʒ
	 * @return
	 */
	List<Commodity> selectAllCommodity();
}
