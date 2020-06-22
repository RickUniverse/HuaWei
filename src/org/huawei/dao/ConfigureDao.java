package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Configure;

/**
 * 配置接口
 * @author Administrator
 *
 */
public interface ConfigureDao {
	/**
	 * 根据配置id查询配置对象
	 * @param id
	 * @return
	 */
	Configure selectConfigureById(int id);
	/**
	 * 根据分类和细分查询配置集合
	 * 商品查询页面
	 * @param cagegoryId
	 * @param seriesId
	 * @return
	 */
	List<Configure> selectConfiguresByCagegoryId(int cagegoryId,int seriesId, String comName);
	/**
	 * 根据商品id查询出该商品所拥有的的所有配置
	 * 商品详情页面
	 * @param CommodityId
	 * 配合下的使用，判断 该颜色id是否包含该配置
	 * @param colorId
	 * @return
	 */
	List<Configure> selectConfiguresByCommodityId(int CommodityId , int colorId);
	/**
	 * 配合上面的使用,判断 该颜色id是否包含该配置
	 * @param CommodityId
	 * @param colorId
	 * @param configureId
	 * @return
	 */
	boolean isExisitByColorId(int CommodityId , int colorId , int configureId);
	/**
	 * 根据cname分页查询
	 * @param cName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Configure> selectAllConfiguresBycName(String cName,int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String cName);
	/**
	 * 添加
	 * @return
	 */
	boolean addConfigure(String confName);
	/**
	 * 删除
	 * @param confId
	 * @return
	 */
	boolean deleteConfigureId(int confId);
	/**
	 * 全部配置
	 * @return
	 */
	List<Configure> selectAllConfiguresBycName();
}
