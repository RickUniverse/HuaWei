package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Series;

/**
 * ϸ�ֽӿ�
 * @author Administrator
 *
 */
public interface SeriesDao {
	/**
	 * ��ȡϸ�ּ���,����ϸ��id��ȡ
	 * @return
	 */
	List<Series> selectSeriesById(int id);
	/**
	 * ��ȡϸ�ּ���,����categoryid��ȡ�����id��ȡ
	 * @return
	 */
	List<Series> selectSeriesByCategoryId(int categoryId);
	/**
	 * ����ϸ��id��ȡһ��ϸ�ֶ���
	 * @param id
	 * @return
	 */
	Series selectOneSeriesById(int id);
	/**
	 * ��ѯ����ϵ��
	 * @return
	 */
	List<Series> selectAllSeries(String serName , int categoryId , int pageNo , int pageSize);
	/**
	 * ��ȡ������
	 * @param serName
	 * @param categoryId
	 * @return
	 */
	int totalCount(String serName , int categoryId );
	/**
	 * ����ϸ��id��ѯ����ϸ������������Ʒ����
	 * @param seriesId
	 * @return
	 */
	int getReCommodityCount(int seriesId);
	/**
	 * ���ϸ��
	 * @param ser
	 * @return
	 */
	boolean addSeries(Series ser);
	/**
	 * ����ϸ��id�޸�ϸ��
	 * @param seriesId
	 * @param sName
	 * @param categoryId
	 * @return
	 */
	boolean updateSeries(int seriesId , String sName , int categoryId);
	/**
	 * ����ϸ��idɾ����ϸ��
	 * @param seriesId
	 * @return
	 */
	boolean deleteSeriesBySeriesId(int seriesId);
	/**
	 * ��ѯȫ��ϵ��
	 * @return
	 */
	List<Series> selectAllSeries();
}
