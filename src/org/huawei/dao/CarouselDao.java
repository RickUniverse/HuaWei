package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Carousel;

/**
 * 轮播接口
 * @author Administrator
 *
 */
public interface CarouselDao {
	/**
	 * 获取所有轮播
	 * @return
	 */
	List<Carousel> selectAllCarousel();
	/**
	 * 添加轮播
	 * @param c
	 * @return
	 */
	boolean AddCarousel(Carousel c);
	/**
	 * 修改
	 * @param href
	 * @param orders
	 * @return
	 */
	boolean updateCarousel(String href , int orders , int carId);
	/**
	 * 删除轮播
	 * @param carId
	 * @return
	 */
	boolean deleteCarousel(int carId);
}
