package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Series;

/**
 * 细分接口
 * @author Administrator
 *
 */
public interface SeriesDao {
	/**
	 * 获取细分集合,根据细分id获取
	 * @return
	 */
	List<Series> selectSeriesById(int id);
	/**
	 * 获取细分集合,根据categoryid获取，类别id获取
	 * @return
	 */
	List<Series> selectSeriesByCategoryId(int categoryId);
	/**
	 * 根据细分id获取一个细分对象
	 * @param id
	 * @return
	 */
	Series selectOneSeriesById(int id);
	/**
	 * 查询所有系列
	 * @return
	 */
	List<Series> selectAllSeries(String serName , int categoryId , int pageNo , int pageSize);
	/**
	 * 获取总数量
	 * @param serName
	 * @param categoryId
	 * @return
	 */
	int totalCount(String serName , int categoryId );
	/**
	 * 根据细分id查询出该细分所关联的商品数量
	 * @param seriesId
	 * @return
	 */
	int getReCommodityCount(int seriesId);
	/**
	 * 添加细分
	 * @param ser
	 * @return
	 */
	boolean addSeries(Series ser);
	/**
	 * 根据细分id修改细分
	 * @param seriesId
	 * @param sName
	 * @param categoryId
	 * @return
	 */
	boolean updateSeries(int seriesId , String sName , int categoryId);
	/**
	 * 按照细分id删除该细分
	 * @param seriesId
	 * @return
	 */
	boolean deleteSeriesBySeriesId(int seriesId);
	/**
	 * 查询全部系列
	 * @return
	 */
	List<Series> selectAllSeries();
}
