package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Commodity;

/**
 * 商品类实现接口
 * @author Administrator
 *
 */
public interface CommodityDao {
	/**
	 * 获取楼层内的商品集合
	 * 首页楼层
	 * @param floorId
	 * @return
	 */
	List<Commodity> selectCommodityByFloorId(int floorId);
	/**
	 * 根据商品id查询商品
	 * @param id
	 * @return
	 */
	Commodity selectCommodityById(int id);
	/**
	 * 根据颜色配置查询到对应的商品对象
	 * 根据颜色配置id查询出对应商品
	 * 商品详情页面
	 * @param colorandConfigureId
	 * @return
	 */
	Commodity selectCommodityByColorandConfigureId(int colorandConfigureId);
	/**
	 * 根据套餐id，查询套餐内商品集合
	 * 根据套餐id获取套餐内的商品
	 * @param CommId
	 * @return
	 */
	List<Commodity> selectCommodityByCommId(int CommId);
	/**
	 * 商品id用来指定查询哪一个商品内的颜色配置
	 * 按照颜色id跟配置id查询出商品的颜色配置
	 * @param commodityId//商品id用来指定是哪一个商品
	 * @param colorId//判断配置跟颜色的关系
	 * @param configureId//判断颜色跟配置的关系
	 * @param comboId//用来控制当前商品选中的套餐
	 * @return
	 */
	Commodity selectCommodityByCommodityIdAndColorIdAndConfigureId(int commodityId , int colorId , int configureId , int comboId);
	/**
	 * 分页查询
	 * @param cName
	 * @param seriesId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Commodity> selectAllCommodityBycNameAndSeriesId(String cName,int seriesId,int pageNo,int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String cName,int seriesId);
	/**
	 * 添加
	 * @param com
	 * @return
	 */
	boolean addCommodity(Commodity com);
	/**
	 * 删除商品
	 * @param comId
	 * @return
	 */
	boolean deleteCommodityByComId(int comId);
	/**
	 * 修改
	 * @return
	 */
	boolean updateCommodity(Commodity com);
	/**
	 * 查询出所有商品
	 * @return
	 */
	List<Commodity> selectAllCommodity();
}
