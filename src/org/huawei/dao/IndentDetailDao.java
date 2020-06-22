package org.huawei.dao;

import java.util.List;

import org.huawei.entity.IndentDetail;

/**
 * 订单详细接口
 * @author Administrator
 *
 */
public interface IndentDetailDao {
	/**
	 * \根据订单id查询该订单的所有详细订单信息
	 * @param indentId
	 * @return
	 */
	List<IndentDetail> selectIndentDetailByIndentId(int indentId);
	/**
	 * 添加详细订单
	 * @param i
	 * @return
	 */
	boolean addIndentDetail(IndentDetail i);
}
