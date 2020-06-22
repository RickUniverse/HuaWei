package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Address;
import org.huawei.entity.HUser;

/**
 * 地址接口
 * @author Administrator
 *
 */
public interface AddressDao {
	/**
	 * 根据地址id获取一个地址对象
	 * @return
	 */
	Address selectAddressByAddressId(int addressid);
	/**
	 * 根据用户名获取地址集合
	 * @param hUserId
	 * @return
	 */
	List<Address> selectAddressByHUserId(int hUserId);
	/**
	 * 根据用户名添加一个用户
	 * @param hUserId
	 * @return
	 */
	boolean addAddressByHUserId(Address a);
}
