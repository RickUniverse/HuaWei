package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Color;

/**
 * ��ɫ�ӿ�
 * @author Administrator
 *
 */
public interface ColorDao {
	/**
	 * ��ȡ��ɫ����
	 * ����id
	 * @param id
	 * @return
	 */
	Color selectColorById(int id);
	/**
	 * ������Ʒ����ѯ��ӵ�е���ɫ����
	 * @param commodityId
	 * �������id�����ж������ɫ���Ƿ���������ã���Ϊtrue ��Ϊ false
	 * @param configureId
	 * @return
	 */
	List<Color> selectColorByCommodityId(int commodityId , int configureId);
	/**
	 * ������ķ�������
	 */
	boolean isExisitByConfigureId(int commodityId , int colorId ,int configureId);
	/**
	 * ��ҳ��ѯ
	 * @param cName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Color> selectAllColorBycName(String cName , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String cName);
	/**
	 * �����ɫ
	 * @param cName
	 * @return
	 */
	boolean addColor(String cName);
	/**
	 * ɾ����ɫ
	 * @param colorId
	 * @return
	 */
	boolean deleteColor(int colorId);
	/**
	 * ȫ����ɫ
	 * @return
	 */
	List<Color> selectAllColorBycName();
}
