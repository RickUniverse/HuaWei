package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Carousel;

/**
 * �ֲ��ӿ�
 * @author Administrator
 *
 */
public interface CarouselDao {
	/**
	 * ��ȡ�����ֲ�
	 * @return
	 */
	List<Carousel> selectAllCarousel();
	/**
	 * ����ֲ�
	 * @param c
	 * @return
	 */
	boolean AddCarousel(Carousel c);
	/**
	 * �޸�
	 * @param href
	 * @param orders
	 * @return
	 */
	boolean updateCarousel(String href , int orders , int carId);
	/**
	 * ɾ���ֲ�
	 * @param carId
	 * @return
	 */
	boolean deleteCarousel(int carId);
}
