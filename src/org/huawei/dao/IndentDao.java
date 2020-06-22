package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Indent;

/**
 * 订单实现接口
 * @author Administrator
 *
 */
public interface IndentDao {
	/**
	 * 根据用户id和订单状态查询订单对象
	 * @param huserId
	 * @return
	 */
	Indent selectIndentByhuserIdAndstatusId(int huserId , int statusId);
	/**
	 * 添加一个订单
	 * @param indent
	 * @return
	 */
	boolean addIndent(Indent i);
	/**
	 * 按照订单id修改订单状态
	 * @param indentId
	 * @return
	 */
	boolean updateIndentStatusByIndentId(int indentId, int statusId);
	/**
	 * 根据订单id查询订单
	 * @param indentId
	 * @return
	 */
	Indent selectIndentByIndentId(int indentId);
	/**
	 * 按照订单id修改订单
	 * @param indentId
	 * @return
	 */
	boolean updateIndentByIndentId(int indentId , int addressId, int integral, double payment, int Stateid);
	/**
	 * 按照用户id查询出所有该订单
	 * @param huserId
	 * @param statusId根据状态
	 * @param pageNo当前页数
	 * @param pageSize每页条数
	 * @return
	 */
	List<Indent> selectIndentByHUserId(int huserId , int statusId , int pageNo , int pageSize);
	/**
	 * 根据用户id跟状态id获取总条数
	 * @param huserId
	 * @param statusId
	 * @return
	 */
	int getTotalCountByHUserIdAndStatusId(int huserId , int statusId);
	/**
	 * 根据indentId修改订单的选中状态
	 * @param hUserId
	 * @return
	 */
	boolean updateCheckedByindentId(int indentId,boolean isChecked);
	/**
	 * 根据多个订单id查询订单
	 * sql   语句使用           in     关键字
	 * @param togoIntendId
	 * @return
	 */
	List<Indent> selectIndentByTogoIndentId(String togoIntendId);
	/**
	 * 数据库使用     in 关键字修改订单状态
	 * @param indentId
	 * @param statusId
	 * @return
	 */
	boolean updateIndentStatusByIndentId(String indentIds, int statusId);
	/**
	 * 后台分页
	 * @param indentId
	 * @param statusId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Indent> selectAllIndent(int indentId , int statusId , int pageNo , int pageSize);
	/**
	 * 获取数量
	 */
	int getTotalCount(int indentId , int statusId);
}
