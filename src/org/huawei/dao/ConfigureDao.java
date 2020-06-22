package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Configure;

/**
 * ���ýӿ�
 * @author Administrator
 *
 */
public interface ConfigureDao {
	/**
	 * ��������id��ѯ���ö���
	 * @param id
	 * @return
	 */
	Configure selectConfigureById(int id);
	/**
	 * ���ݷ����ϸ�ֲ�ѯ���ü���
	 * ��Ʒ��ѯҳ��
	 * @param cagegoryId
	 * @param seriesId
	 * @return
	 */
	List<Configure> selectConfiguresByCagegoryId(int cagegoryId,int seriesId, String comName);
	/**
	 * ������Ʒid��ѯ������Ʒ��ӵ�еĵ���������
	 * ��Ʒ����ҳ��
	 * @param CommodityId
	 * ����µ�ʹ�ã��ж� ����ɫid�Ƿ����������
	 * @param colorId
	 * @return
	 */
	List<Configure> selectConfiguresByCommodityId(int CommodityId , int colorId);
	/**
	 * ��������ʹ��,�ж� ����ɫid�Ƿ����������
	 * @param CommodityId
	 * @param colorId
	 * @param configureId
	 * @return
	 */
	boolean isExisitByColorId(int CommodityId , int colorId , int configureId);
	/**
	 * ����cname��ҳ��ѯ
	 * @param cName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Configure> selectAllConfiguresBycName(String cName,int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String cName);
	/**
	 * ���
	 * @return
	 */
	boolean addConfigure(String confName);
	/**
	 * ɾ��
	 * @param confId
	 * @return
	 */
	boolean deleteConfigureId(int confId);
	/**
	 * ȫ������
	 * @return
	 */
	List<Configure> selectAllConfiguresBycName();
}
