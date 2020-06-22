package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.AddressDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.ShoppingCartDao;
import org.huawei.entity.HUser;
import org.huawei.util.BaseDao;

public class HUserImpl extends BaseDao implements HUserDao {
	/**
	 * 实现查询用户的功能
	 */
	@Override
	public HUser selectHUserById(int huserid) {
		HUser h = null;
		ShoppingCartDao scImp = new ShoppingCartImpl();
		AddressDao aImp = new AddressImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM huser AS hu WHERE  hu.`id` = "+huserid+"");
		try {
			while(rs.next()){
				h = new HUser();
				h.setBirthday(rs.getDate("hu.birthday"));
				h.setCashCoupon(rs.getInt("hu.cashCoupon"));
				h.setCountry(rs.getString("hu.country"));
				h.setId(rs.getInt("hu.id"));
				h.setOnsaleCoupon(rs.getInt("hu.onsaleCoupon"));
				h.setPetal(rs.getInt("hu.petal"));
				h.setPhone(rs.getString("hu.phone"));
				h.setPhoto(rs.getString("hu.photo"));
				h.setTotal(rs.getInt("hu.total"));
				h.setuName(rs.getString("hu.uName"));
				h.setuPassword(rs.getString("hu.uPassword"));
				h.setDefaultAddress(rs.getInt("hu.defaultAddress"));
				
				h.setTotalIndent(totalIndent(rs.getInt("hu.id")));
				
				h.setYouPrice(scImp.selectYouPrice(huserid));
				h.setTotalCheck(scImp.selectTotalCheck(huserid));
				h.setTotalPrice(scImp.selectTotalPrice(huserid));
				
				h.setAddredd(aImp.selectAddressByAddressId(rs.getInt("hu.defaultAddress")));
				h.setAddressLi(aImp.selectAddressByHUserId(rs.getInt("hu.id")));
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
		return h;
	}
	/**
	 * 修改默认地址
	 */
	@Override
	public boolean updateDefaultAddressByhuserid(int addressId, int huserid) {
		return super.executeUpdate(null, "UPDATE huser AS h SET h.`defaultAddress` = "+addressId+" WHERE h.`id` = "+huserid+";");
	}
	/**
	 * 后台用户管理获取所有用户
	 * @return
	 */
	@Override
	public List<HUser> selectAllHUser(int pageNo , int pageSize) {
		List<HUser> hli = new ArrayList<HUser>();
		AddressDao aImp = new AddressImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM huser as hu LIMIT "+(pageNo - 1) * pageSize+" , "+pageSize+"");
		try {
			while(rs.next()){
				HUser h = new HUser();
				h.setBirthday(rs.getDate("hu.birthday"));
				h.setCashCoupon(rs.getInt("hu.cashCoupon"));
				h.setCountry(rs.getString("hu.country"));
				h.setId(rs.getInt("hu.id"));
				h.setOnsaleCoupon(rs.getInt("hu.onsaleCoupon"));
				h.setPetal(rs.getInt("hu.petal"));
				h.setPhone(rs.getString("hu.phone"));
				h.setPhoto(rs.getString("hu.photo"));
				h.setTotal(rs.getInt("hu.total"));
				h.setuName(rs.getString("hu.uName"));
				h.setuPassword(rs.getString("hu.uPassword"));
				h.setDefaultAddress(rs.getInt("hu.defaultAddress"));

				h.setTotalIndent(totalIndent(rs.getInt("hu.id")));
				
				h.setAddredd(aImp.selectAddressByAddressId(rs.getInt("hu.defaultAddress")));
				h.setAddressLi(aImp.selectAddressByHUserId(rs.getInt("hu.id")));
				hli.add(h);
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
		return hli;
	}
	/**
	 * 获取所有用户的条数
	 * @return
	 */
	@Override
	public int totalCountHUser() {
		int totalCount = 0;
		ResultSet rs = super.executeQuery(null, "SELECT count(0) as totalCount FROM huser");
		try {
			while(rs.next()){
				totalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	/**
	 * 我的订单数量
	 */
	@Override
	public int totalIndent(int hUserId) {
		int totalCount = 0;
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS totalCount FROM indent AS i WHERE i.huserId = "+hUserId+"");
		try {
			while(rs.next()){
				totalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}

}
