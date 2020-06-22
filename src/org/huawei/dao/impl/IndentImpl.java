package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.huawei.dao.AddressDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.IndentDao;
import org.huawei.dao.IndentDetailDao;
import org.huawei.dao.IndentStatusDao;
import org.huawei.entity.Indent;
import org.huawei.util.BaseDao;

/**
 * 查询订单实现类
 * @author Administrator
 *
 */
public class IndentImpl extends BaseDao implements IndentDao {
	/**
	 * 实现根据订单id查询订单的方法
	 */
	@Override
	public Indent selectIndentByhuserIdAndstatusId(int huserId , int statusId) {
		Indent i = null;
		HUserDao huImp = new HUserImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		AddressDao aImp = new AddressImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indent AS i WHERE i.`huserid` = "+huserId+" AND i.`Stateid` = "+statusId+";");
		try {
			while(rs.next()){
				i = new Indent();
				i.setAddress(aImp.selectAddressByAddressId(rs.getInt("i.addressId")));
				i.setAddressId(rs.getInt("i.addressId"));
				i.setChecked(true);
				i.sethUser(huImp.selectHUserById(rs.getInt("i.huserid")));
				i.setHuserid(rs.getInt("i.huserid"));
				i.setId(rs.getInt("i.id"));
				i.setIndentState(isImp.selectIndentStatusByIndentStatusId(rs.getInt("i.Stateid")));
				i.setIntegral(rs.getInt("i.integral"));
				i.setOrderdate(rs.getDate("i.orderdate"));
				i.setPayment(rs.getDouble("i.payment"));
				i.setStateid(rs.getInt("i.Stateid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	/**
	 * 实现添加一个订单
	 */
	@Override
	public boolean addIndent(Indent i) {
		return super.executeUpdate(new Object[]{i.getHuserid(),i.getStateid(),true,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),i.getAddressId(),i.getPayment(),i.getIntegral()}, "INSERT INTO indent(huserid,Stateid,checked,orderdate,addressId,payment,integral) VALUES(?,?,?,?,?,?,?)");
	}
	/**
	 * 修改订单的状态
	 */
	@Override
	public boolean updateIndentStatusByIndentId(int indentId, int statusId) {
		return super.executeUpdate(null, "UPDATE indent AS i SET i.`Stateid` = "+statusId+" WHERE i.`id` = "+indentId+"");
	}
	/**
	 * 按照订单id查询该订单
	 */
	@Override
	public Indent selectIndentByIndentId(int indentId) {
		Indent i = null;
		HUserDao huImp = new HUserImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		AddressDao aImp = new AddressImpl();
		IndentDetailDao idImp = new IndentDetailImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indent AS i WHERE i.`id` = "+indentId+";");
		try {
			while(rs.next()){
				i = new Indent();
				i.setAddress(aImp.selectAddressByAddressId(rs.getInt("i.addressId")));
				i.setAddressId(rs.getInt("i.addressId"));
				i.setChecked(true);
				i.sethUser(huImp.selectHUserById(rs.getInt("i.huserid")));
				i.setHuserid(rs.getInt("i.huserid"));
				i.setId(rs.getInt("i.id"));
				i.setIndentState(isImp.selectIndentStatusByIndentStatusId(rs.getInt("i.Stateid")));
				i.setIntegral(rs.getInt("i.integral"));
				i.setOrderdate(rs.getDate("i.orderdate"));
				i.setPayment(rs.getDouble("i.payment"));
				i.setStateid(rs.getInt("i.Stateid"));
				
				i.setIndentDetailLi(idImp.selectIndentDetailByIndentId(rs.getInt("i.id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	/**
	 * 修改订单
	 */
	@Override
	public boolean updateIndentByIndentId(int indentId, int addressId, int integral, double payment, int Stateid) {
		return super.executeUpdate(null, "UPDATE indent AS i SET i.`addressId` = "+addressId+" , i.`integral` = "+integral+" , i.`payment` = "+payment+" , i.`Stateid` = "+Stateid+" WHERE i.`id` = "+indentId+"");
	}
	/**
	 * 按照用户id查询出所有该订单
	 * @param huserId
	 * @param statusId根据状态
	 * @param pageNo当前页数
	 * @param pageSize每页条数
	 * @return
	 */
	@Override
	public List<Indent> selectIndentByHUserId(int huserId, int statusId, int pageNo, int pageSize) {
		List<Indent> ili = new ArrayList<Indent>();
		HUserDao huImp = new HUserImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		AddressDao aImp = new AddressImpl();
		IndentDetailDao idImp = new IndentDetailImpl();
		
		StringBuffer sql = new StringBuffer("SELECT * FROM indent AS i WHERE i.`huserid` = "+huserId+"");
		if(statusId>0){
			sql.append(" AND i.`Stateid` = "+statusId+"");
		}
		sql.append(" LIMIT "+(pageNo-1)*pageSize+","+pageSize+";");
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				Indent i = new Indent();
				i.setAddress(aImp.selectAddressByAddressId(rs.getInt("i.addressId")));
				i.setAddressId(rs.getInt("i.addressId"));
				i.setChecked(rs.getBoolean("i.checked"));
				i.sethUser(huImp.selectHUserById(rs.getInt("i.huserid")));
				i.setHuserid(rs.getInt("i.huserid"));
				i.setId(rs.getInt("i.id"));
				i.setIndentState(isImp.selectIndentStatusByIndentStatusId(rs.getInt("i.Stateid")));
				i.setIntegral(rs.getInt("i.integral"));
				i.setOrderdate(rs.getDate("i.orderdate"));
				i.setPayment(rs.getDouble("i.payment"));
				i.setStateid(rs.getInt("i.Stateid"));
				
				i.setIndentDetailLi(idImp.selectIndentDetailByIndentId(rs.getInt("i.id")));
				
				ili.add(i);
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
		return ili;
	}
	/**
	 * 根据用户id跟状态id获取总条数
	 * @param huserId
	 * @param statusId
	 * @return
	 */
	@Override
	public int getTotalCountByHUserIdAndStatusId(int huserId, int statusId) {
		int totalCount = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(0) AS totalCount FROM indent AS i WHERE i.`huserid` = "+huserId+"");
		if(statusId>0){
			sql.append(" AND i.`Stateid` = "+statusId+"");
		}
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				totalCount = rs.getInt("totalCount");
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
		return totalCount;
	}
	@Override
	public boolean updateCheckedByindentId(int indentId,boolean isChecked) {
		return super.executeUpdate(null, "UPDATE indent SET checked = "+isChecked+" WHERE id = "+indentId+";");
	}
	/**
	 * 根据多个订单id查询订单
	 * sql   语句使用           in     关键字
	 * @param togoIntendId
	 * @return
	 */
	@Override
	public List<Indent> selectIndentByTogoIndentId(String togoIntendId) {
		List<Indent> ili = new ArrayList<Indent>();
		HUserDao huImp = new HUserImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		AddressDao aImp = new AddressImpl();
		IndentDetailDao idImp = new IndentDetailImpl();
		
		StringBuffer sql = new StringBuffer("SELECT * FROM indent AS i WHERE i.`id` IN("+togoIntendId+");");
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				Indent i = new Indent();
				i.setAddress(aImp.selectAddressByAddressId(rs.getInt("i.addressId")));
				i.setAddressId(rs.getInt("i.addressId"));
				i.setChecked(rs.getBoolean("i.checked"));
				i.sethUser(huImp.selectHUserById(rs.getInt("i.huserid")));
				i.setHuserid(rs.getInt("i.huserid"));
				i.setId(rs.getInt("i.id"));
				i.setIndentState(isImp.selectIndentStatusByIndentStatusId(rs.getInt("i.Stateid")));
				i.setIntegral(rs.getInt("i.integral"));
				i.setOrderdate(rs.getDate("i.orderdate"));
				i.setPayment(rs.getDouble("i.payment"));
				i.setStateid(rs.getInt("i.Stateid"));
				
				i.setIndentDetailLi(idImp.selectIndentDetailByIndentId(rs.getInt("i.id")));
				
				ili.add(i);
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
		return ili;
	}
	/**
	 * 数据库使用     in 关键字修改订单状态
	 * @param indentId
	 * @param statusId
	 * @return
	 */
	@Override
	public boolean updateIndentStatusByIndentId(String indentIds, int statusId) {
		return super.executeUpdate(null, "UPDATE indent SET Stateid = "+statusId+" WHERE id IN("+indentIds+");");
	}
	/**
	 * 后台分页
	 */
	@Override
	public List<Indent> selectAllIndent(int indentId, int statusId, int pageNo, int pageSize) {
		List<Indent> ili = new ArrayList<Indent>();
		HUserDao huImp = new HUserImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		AddressDao aImp = new AddressImpl();
		IndentDetailDao idImp = new IndentDetailImpl();
		
		StringBuffer sql = new StringBuffer("SELECT * FROM indent AS i WHERE 1=1");
		if(indentId>0){
			sql.append(" AND i.`id` = "+indentId+"");
		}
		if(statusId>0){
			sql.append(" AND i.`Stateid` = "+statusId+"");
		}
		sql.append(" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";");
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				Indent i = new Indent();
				i.setAddress(aImp.selectAddressByAddressId(rs.getInt("i.addressId")));
				i.setAddressId(rs.getInt("i.addressId"));
				i.setChecked(rs.getBoolean("i.checked"));
				i.sethUser(huImp.selectHUserById(rs.getInt("i.huserid")));
				i.setHuserid(rs.getInt("i.huserid"));
				i.setId(rs.getInt("i.id"));
				i.setIndentState(isImp.selectIndentStatusByIndentStatusId(rs.getInt("i.Stateid")));
				i.setIntegral(rs.getInt("i.integral"));
				i.setOrderdate(rs.getDate("i.orderdate"));
				i.setPayment(rs.getDouble("i.payment"));
				i.setStateid(rs.getInt("i.Stateid"));
				
				i.setIndentDetailLi(idImp.selectIndentDetailByIndentId(rs.getInt("i.id")));
				
				ili.add(i);
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
		return ili;
	}
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(int indentId, int statusId) {
		int totalCount = 0;
		StringBuffer sql = new StringBuffer("SELECT count(0) as totalCount FROM indent AS i WHERE 1=1");
		if(indentId>0){
			sql.append(" AND i.`id` = "+indentId+"");
		}
		if(statusId>0){
			sql.append(" AND i.`Stateid` = "+statusId+"");
		}
		ResultSet rs = super.executeQuery(null, sql.toString());
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
