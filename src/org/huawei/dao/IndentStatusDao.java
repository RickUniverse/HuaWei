package org.huawei.dao;

import java.util.List;

import org.huawei.entity.IndentStatus;

/**
 * 订单状态接口
 * @author Administrator
 *
 */
public interface IndentStatusDao {
	/**
	 * 根据订单状态id查询状态
	 * @param IndentStatusId
	 * @return
	 */
	IndentStatus selectIndentStatusByIndentStatusId(int IndentStatusId);
	/**
	 * 查询出不包含id为    1  的所有状态
	 * 
	 * 用户id为了判断该用户的订单分别拥有几种类型的状态数量
	 * @return
	 */
	List<IndentStatus> selectIndentStatusByAll(int hUserId);
	/**
	 * 按照状态id跟用户id查询该用户拥有改状态的订单的数量
	 * @param hUserId
	 * @param IndentStatusId
	 * @return
	 */
	int getCountByHUserIdAndStatusId(int hUserId,int IndentStatusId);
	/**
	 * 查询所有状态
	 * @return
	 */
	List<IndentStatus> selectIndentStatus();
}
