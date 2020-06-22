package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.huawei.dao.AdminDao;
import org.huawei.entity.Admin;
import org.huawei.entity.Color;
import org.huawei.util.BaseDao;

public class AdminImpl extends BaseDao implements AdminDao {
	/**
	 * ��¼�����ع���Ա����
	 * @param aName
	 * @param password
	 * @return
	 */
	@Override
	public Admin loginByANameAndPassword(String aName, String password) {
		Admin a = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM admin AS a WHERE a.`aName` =  '"+aName+"' AND a.`aPassword` = '"+password+"';");
		try {
			while(rs.next()){
				a = new Admin();
				a.setaName(rs.getString("a.aName"));
				a.setaPassword(rs.getString("a.aPassword"));
				a.setCategoryTotal(getCategoryTotal());
				a.setComTotal(getComodityTotal());
				a.sethUserTotal(getHUserTotal());
				a.setId(rs.getInt("a.id"));
				a.setIndentTotal(getIndentTotal());
				a.setSeriesTotal(getSeriesTotal());
				a.setTotalPrice(getTotalPrice());
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
	 * ͳ����Ʒ����
	 */
	@Override
	public int getComodityTotal() {
		int total = 0;
		String sql = "SELECT count(0) as total FROM commodity";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	/**
	 * ͳ����Ʒ��������
	 */
	@Override
	public int getCategoryTotal() {
		int total = 0;
		String sql = "SELECT count(0) as total FROM category";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	/**
	 * ͳ����Ʒϸ������
	 */
	@Override
	public int getSeriesTotal() {
		int total = 0;
		String sql = "SELECT count(0) as total FROM series";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	/**
	 * ͳ�ƶ�������
	 */
	@Override
	public int getIndentTotal() {
		int total = 0;
		String sql = "SELECT count(0) as total FROM indent";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	/**
	 * ͳ���û�����
	 */
	@Override
	public int getHUserTotal() {
		int total = 0;
		String sql = "SELECT count(0) as total FROM huser";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	/**
	 * ͳ����Ӫҵ��
	 */
	@Override
	public long getTotalPrice() {
		long total = 0;
		String sql = "SELECT AVG(i.`payment`) AS total FROM indent AS i WHERE i.`Stateid` = 6";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				total = rs.getLong("total");
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
		return total;
	}
	
}
