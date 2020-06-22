package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Promotion;

/**
 * 促销接口
 * @author Administrator
 *
 */
public interface PromotionDao {
	/**
	 * 根据促销id查询促销
	 * @param id
	 * @return
	 */
	Promotion selectPromotionById(int id);
	/**
	 * 按照颜色配置表查询出所有促销并返回一个集合
	 * @param colorandConfigureId
	 * @return
	 */
	List<Promotion> selectPromotionByColorandConfigureId(int colorandConfigureId);
	/**
	 * 分页查询促销
	 * @param title
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Promotion> selectAllPromotionByTitle(String title , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(String title);
	/**
	 * 添加促销
	 * @param tit
	 * @param con
	 * @return
	 */
	boolean addPromotion(String tit , String con);
	/**
	 * 删除
	 * @param proId
	 * @return
	 */
	boolean deletePromotion(int proId);
	/**
	 * 全部促销
	 * @return
	 */
	List<Promotion> selectAllPromotionByTitle();
}
