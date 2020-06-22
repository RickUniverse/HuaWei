package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Address;
import org.huawei.entity.HUser;

/**
 * ��ַ�ӿ�
 * @author Administrator
 *
 */
public interface AddressDao {
	/**
	 * ���ݵ�ַid��ȡһ����ַ����
	 * @return
	 */
	Address selectAddressByAddressId(int addressid);
	/**
	 * �����û�����ȡ��ַ����
	 * @param hUserId
	 * @return
	 */
	List<Address> selectAddressByHUserId(int hUserId);
	/**
	 * �����û������һ���û�
	 * @param hUserId
	 * @return
	 */
	boolean addAddressByHUserId(Address a);
}
