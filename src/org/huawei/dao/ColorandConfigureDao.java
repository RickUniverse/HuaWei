package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ColorandConfigure;

/**
 * 颜色跟配置接口
 * @author Administrator
 *
 */
public interface ColorandConfigureDao {
	/**
	 * 根据楼层id查询相应的颜色配置
	 * @param id
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureById(int floorid);
	/**
	 * 查询商品按照下列内容
	 * @param minPrice最小价格
	 * @param maxPrice最大价格
	 * @param categoryId类别id
	 * @param seriseId细分id
	 * @param configureId配置id
	 * @param pageNo当前页
	 * @param PageSize每页条数
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(double minPrice , double maxPrice , int categoryId , int seriseId , int configureId  , String cName , int pageNo , int PageSize);
	/**
	 * 查询总条数
	 * @param minPrice
	 * @param maxPrice
	 * @param categoryId
	 * @param seriseId
	 * @param configureId
	 * @return
	 */
	int getTotalCount(double minPrice , double maxPrice , int categoryId , int seriseId , int configureId , String cName);
	/**
	 * 返回查询到的第一条，数据按照commodity
	 * 按照商品id查询出匹配到的第一行数据并返回为对象
	 * @param commodityId
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByCommodityId(int commodityId);
	/**
	 * 根据颜色配置id查询到对应的对象
	 * 以应用在商品内的方法
	 * @param ColorandConfigureid
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByColorandConfigureId(int colorandConfigureId);
	/**
	 * 根据颜色id跟配置id查询出啦一个颜色配置对象
	 * @param commodityId//指定是哪个商品
	 * @param colorId
	 * @param configureId
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByColorIdAndConfigureId(int commodityId , int colorId, int configureId);
	/**
	 * 后台分页查询
	 * @param comName
	 * @param colorId
	 * @param configureId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureById(String comName , int colorId , int configureId , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String comName , int colorId , int configureId);
	/**
	 * 添加
	 * @param c
	 * @return
	 */
	boolean addColorAndConfigure(ColorandConfigure c);
	/**
	 * 修改颜色跟配置
	 * @param c
	 * @return
	 */
	boolean updateColorAndConfigure(ColorandConfigure c);
	/**
	 * 删除
	 * @param couId
	 * @return
	 */
	boolean deleteColorAndConfigure(int couId);
	/**
	 * 楼层分页查询
	 * @param floorId
	 * @param couId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureByIdByFloor(int floorId , int couId , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(int floorId , int couId);
}
