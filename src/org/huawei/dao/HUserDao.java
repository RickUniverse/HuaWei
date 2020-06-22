package org.huawei.dao;

import java.util.List;

import org.huawei.entity.HUser;

/**
 * 华为用户接口
 * @author Administrator
 *
 */
public interface HUserDao {
	/**
	 * 按照huserid查询出华为用户
	 * @param huserid
	 * @return
	 */
	HUser selectHUserById(int huserid);
	/**
	 * 按照用户id修改该用户的默认地址
	 * @param addressId
	 * @return
	 */
	boolean updateDefaultAddressByhuserid(int addressId,int huserid);
	/**
	 * 后台用户管理获取所有用户
	 * 按照分页
	 * @return
	 */
	List<HUser> selectAllHUser(int pageNo , int pageSize);
	/**
	 * 获取所有用户的条数
	 * @return
	 */
	int totalCountHUser();
	/**
	 * 我的订单数量
	 * @return
	 */
	int totalIndent(int hUserId);
}
