package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ComboCommodityDao;
import org.huawei.dao.ComboDao;
import org.huawei.dao.CommodityDao;
import org.huawei.entity.ComboCommodity;
import org.huawei.util.BaseDao;

public class ComboCommodityImpl extends BaseDao implements ComboCommodityDao {
	/**
	 * 分页查询
	 */
	@Override
	public List<ComboCommodity> selectAllComboByComboId(String comboName, String commodityName, int pageNo,
			int pageSize) {
		List<ComboCommodity> comcomli = new ArrayList<ComboCommodity>();
		CommodityDao comImp = new CommodityImpl();
		ComboDao comboImp = new ComboImpl();
		String sql = "SELECT comm.* FROM combocommodity AS comm INNER JOIN combo AS cb ON cb.`id` = comm.`Comboid` INNER JOIN commodity AS c ON c.`id` = comm.`Commodityid` WHERE 1=1";
		if(comboName!=null&&!comboName.equals("")){
			sql += " AND cb.`cName` LIKE '%"+comboName+"%'";
		}
		if(commodityName!=null&&!commodityName.equals("")){
			sql += " AND c.`cName` LIKE '%"+commodityName+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				ComboCommodity c = new ComboCommodity();
				c.setCombo(comboImp.selectOneComboByComboId(rs.getInt("comm.Comboid")));
				c.setComboId(rs.getInt("comm.Comboid"));
				c.setCommodity(comImp.selectCommodityById(rs.getInt("comm.Commodityid")));
				c.setCommodityId(rs.getInt("comm.Commodityid"));
				c.setId(rs.getInt("comm.id"));
				comcomli.add(c);
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
		return comcomli;
	}
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(String comboName, String commodityName) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM combocommodity AS comm INNER JOIN combo AS cb ON cb.`id` = comm.`Comboid` INNER JOIN commodity AS c ON c.`id` = comm.`Commodityid` WHERE 1=1";
		if(comboName!=null&&!comboName.equals("")){
			sql += " AND cb.`cName` LIKE '%"+comboName+"%'";
		}
		if(commodityName!=null&&!commodityName.equals("")){
			sql += " AND c.`cName` LIKE '%"+commodityName+"%'";
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
	/**
	 * 添加
	 */
	@Override
	public boolean addComboCommodity(int comboId, int commodityId) {
		return super.executeUpdate(null, "INSERT INTO combocommodity(Comboid,Commodityid) VALUES("+comboId+","+commodityId+")");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean removeComboCommodity(int comboCommodityId) {
		return super.executeUpdate(null, "DELETE FROM combocommodity WHERE id = "+comboCommodityId+"");
	}

}
