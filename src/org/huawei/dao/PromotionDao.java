package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Promotion;

/**
 * �����ӿ�
 * @author Administrator
 *
 */
public interface PromotionDao {
	/**
	 * ���ݴ���id��ѯ����
	 * @param id
	 * @return
	 */
	Promotion selectPromotionById(int id);
	/**
	 * ������ɫ���ñ��ѯ�����д���������һ������
	 * @param colorandConfigureId
	 * @return
	 */
	List<Promotion> selectPromotionByColorandConfigureId(int colorandConfigureId);
	/**
	 * ��ҳ��ѯ����
	 * @param title
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Promotion> selectAllPromotionByTitle(String title , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String title);
	/**
	 * ��Ӵ���
	 * @param tit
	 * @param con
	 * @return
	 */
	boolean addPromotion(String tit , String con);
	/**
	 * ɾ��
	 * @param proId
	 * @return
	 */
	boolean deletePromotion(int proId);
	/**
	 * ȫ������
	 * @return
	 */
	List<Promotion> selectAllPromotionByTitle();
}
