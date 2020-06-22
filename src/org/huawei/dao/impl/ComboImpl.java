package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ComboDao;
import org.huawei.dao.CommodityDao;
import org.huawei.entity.Color;
import org.huawei.entity.Combo;
import org.huawei.util.BaseDao;

public class ComboImpl extends BaseDao implements ComboDao {
	/**
	 * 商品拥有的所有套餐
	 */
	@Override
	public List<Combo> selectComboByCommodityId(int commodityId) {
		List<Combo> comli = new ArrayList<Combo>();
		CommodityDao comImp = new CommodityImpl();
		ResultSet rs = super.executeQuery(null, "SELECT com.* FROM combo AS com LEFT JOIN commodity AS cod ON com.`Commodityid` = cod.`id` WHERE cod.`id` = "+commodityId+" GROUP BY com.cName;");
		try {
			while(rs.next()){
				Combo c = new Combo();
				c.setCommodity(comImp.selectCommodityById(rs.getInt("com.Commodityid")));
				c.setCommodityId(rs.getInt("com.Commodityid"));
				c.setCommodityLi(comImp.selectCommodityByCommId(rs.getInt("com.id")));
				c.setcName(rs.getString("com.cName"));
				c.setId(rs.getInt("com.id"));
				c.setPrice(rs.getDouble("com.price"));
				c.setHuiPrice(rs.getDouble("com.huiPrice"));
				comli.add(c);
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
		return comli;
	}
	/**
	 * 根据套餐id获取一个套餐对象
	 */
	@Override
	public Combo selectOneComboByComboId(int comboId) {
		Combo c = null;
		CommodityDao comImp = new CommodityImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM combo as com WHERE id = "+comboId+"");
		try {
			while(rs.next()){
				c = new Combo();
				c.setCommodity(comImp.selectCommodityById(rs.getInt("com.Commodityid")));
				c.setCommodityId(rs.getInt("com.Commodityid"));
				c.setCommodityLi(comImp.selectCommodityByCommId(rs.getInt("com.id")));
				c.setcName(rs.getString("com.cName"));
				c.setId(rs.getInt("com.id"));
				c.setPrice(rs.getDouble("com.price"));
				c.setHuiPrice(rs.getDouble("com.huiPrice"));
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
		return c;
	}
	/**
	 * 获取分页查询结果
	 */
	@Override
	public List<Combo> selectAllComboByComboName(String comboName, String commodityName, int pageNo, int pageSize) {
		List<Combo> comli = new ArrayList<Combo>();
		CommodityDao comImp = new CommodityImpl();
		String sql = "SELECT com.* FROM combo AS com LEFT JOIN commodity AS cod ON com.`Commodityid` = cod.`id` WHERE 1=1";
		if(comboName!=null&&!comboName.equals("")){
			sql += " AND com.`cName` LIKE '%"+comboName+"%'";
		}
		if(commodityName!=null&&!commodityName.equals("")){
			sql += " AND cod.`cName` LIKE '%"+commodityName+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Combo c = new Combo();
				c.setCommodity(comImp.selectCommodityById(rs.getInt("com.Commodityid")));
				c.setCommodityId(rs.getInt("com.Commodityid"));
				c.setCommodityLi(comImp.selectCommodityByCommId(rs.getInt("com.id")));
				c.setcName(rs.getString("com.cName"));
				c.setId(rs.getInt("com.id"));
				c.setPrice(rs.getDouble("com.price"));
				c.setHuiPrice(rs.getDouble("com.huiPrice"));
				comli.add(c);
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
		return comli;
	}
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(String comboName, String commodityName) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM combo AS com LEFT JOIN commodity AS cod ON com.`Commodityid` = cod.`id` WHERE 1=1";
		if(comboName!=null&&!comboName.equals("")){
			sql += " AND com.`cName` LIKE '%"+comboName+"%'";
		}
		if(commodityName!=null&&!commodityName.equals("")){
			sql += " AND cod.`cName` LIKE '%"+commodityName+"%'";
		}
		ResultSet rs = super.executeQuery(null, sql);
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
	//添加套餐
	@Override
	public boolean addCombo(Combo c) {
		return super.executeUpdate(new Object[]{c.getcName(),c.getPrice(),c.getCommodityId(),c.getHuiPrice()}, "INSERT INTO combo(cName,price,Commodityid,huiPrice) VALUES(?,?,?,?)");
	}
	//删除套餐
	@Override
	public boolean deleteCombo(int comboId) {
		return super.executeUpdate(null, "DELETE FROM combo WHERE id = "+comboId+"");
	}

}
