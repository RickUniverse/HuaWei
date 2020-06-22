package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.AddressDao;
import org.huawei.dao.HUserDao;
import org.huawei.entity.Address;
import org.huawei.entity.HUser;
import org.huawei.util.BaseDao;
/**
 * 地址实现类
 * @author Administrator
 *
 */
public class AddressImpl extends BaseDao implements AddressDao {
	/**
	 * 根据地址id获取该地址
	 */
	@Override
	public Address selectAddressByAddressId(int addressid) {
		Address a = null;
		HUserDao huImp = new HUserImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM address AS a WHERE a.`id` = "+addressid+";");
		try {
			while(rs.next()){
				a = new Address();
				a.setaName(rs.getString("a.aName"));
				a.setCountry(rs.getString("a.country"));
				a.setDetail(rs.getString("a.detail"));
				/*a.sethUser(huImp.selectHUserById(rs.getInt("a.huserid")));*/
				a.setHuserid(rs.getInt("a.huserid"));
				a.setId(rs.getInt("a.id"));
				a.setPhone(rs.getString("a.phone"));
				a.setPostcode(rs.getString("a.postcode"));
				a.setRePhone(rs.getString("a.rePhone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	/**
	 * 根据用户id获取该用户拥有的地址集合
	 */
	@Override
	public List<Address> selectAddressByHUserId(int hUserId) {
		List<Address> aLi = new ArrayList<Address>();
 		HUserDao huImp = new HUserImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM address AS a WHERE a.`huserid` = "+hUserId+";");
		try {
			while(rs.next()){
				Address a = new Address();
				a.setaName(rs.getString("a.aName"));
				a.setCountry(rs.getString("a.country"));
				a.setDetail(rs.getString("a.detail"));
				/*a.sethUser(huImp.selectHUserById(rs.getInt("a.huserid")));*/
				a.setHuserid(rs.getInt("a.huserid"));
				a.setId(rs.getInt("a.id"));
				a.setPhone(rs.getString("a.phone"));
				a.setPostcode(rs.getString("a.postcode"));
				a.setRePhone(rs.getString("a.rePhone"));
				aLi.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aLi;
	}
	@Override
	public boolean addAddressByHUserId(Address a) {
		return super.executeUpdate(new Object[]{a.getaName(),a.getPhone(),a.getCountry(),a.getDetail(),a.getHuserid()}, "INSERT INTO address(aName,phone,country,detail,huserid,rePhone,postcode) VALUES(?,?,?,?,?,'','')");
	}

}
