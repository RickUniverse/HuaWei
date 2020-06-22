package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ColorDao;
import org.huawei.entity.Color;
import org.huawei.util.BaseDao;

public class ColorImpl extends BaseDao implements ColorDao {
	/**
	 * 颜色实现类
	 */
	@Override
	public Color selectColorById(int id) {
		Color c = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM color WHERE id = "+id+";");
		try {
			while(rs.next()){
				c = new Color(rs.getInt("id"),rs.getString("cName"));
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
	 * 根据商品id获取颜色集合
	 *--运用在configureID为了判断该配置是否包含这个颜色
	 */
	@Override
	public List<Color> selectColorByCommodityId(int commodityId , int configureId) {
		List<Color> cli = new ArrayList<Color>();
		ColorDao climp = new ColorImpl();
		ResultSet rs = super.executeQuery(null, "SELECT co.*,cou.`images` FROM color AS co LEFT JOIN colorandconfigure AS cou ON co.`id` = cou.`colorId` WHERE cou.`commodityId` = "+commodityId+" GROUP BY co.id;");
		try {
			while(rs.next()){
				Color c = new Color();
				c.setId(rs.getInt("co.id"));
				c.setcName(rs.getString("co.cName"));
				c.setExist(climp.isExisitByConfigureId(commodityId, rs.getInt("co.id"), configureId));
				c.setImages(rs.getString("cou.images"));
				cli.add(c);
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
		return cli;
	}
	/**
	 * 用来判断是否改颜色是否包含在该配置中
	 */
	@Override
	public boolean isExisitByConfigureId(int commodityId , int colorId ,int configureId) {
		boolean isExisit = false;
		String sql = "SELECT COUNT(*) AS coun FROM colorandconfigure AS c LEFT JOIN commodity AS com ON c.`commodityId` = com.`id` WHERE com.`id` = "+commodityId+"";
		if(colorId != 0){
			sql += " AND c.`colorId` = "+colorId+"";
		}
		if(configureId != 0){
			sql += " AND c.`configureId` = "+configureId+"";
		}
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				isExisit = rs.getInt("coun") > 0;
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
		return isExisit;
	}
	@Override
	public List<Color> selectAllColorBycName(String cName, int pageNo, int pageSize) {
		List<Color> cli = new ArrayList<Color>();
		String sql = "SELECT * FROM color AS co WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND co.`cName` LIKE '%"+cName+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Color c = new Color();
				c.setId(rs.getInt("co.id"));
				c.setcName(rs.getString("co.cName"));
				cli.add(c);
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
		return cli;
	}
	@Override
	public int getTotalCount(String cName) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM color AS co WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND co.`cName` LIKE '%"+cName+"%'";
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
	public boolean addColor(String cName) {
		return super.executeUpdate(null, "INSERT INTO color(cName) VALUES('"+cName+"')");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteColor(int colorId) {
		return super.executeUpdate(null, "DELETE FROM color WHERE id = "+colorId+"");
	}
	/**
	 * 全部颜色
	 */
	@Override
	public List<Color> selectAllColorBycName() {
		List<Color> cli = new ArrayList<Color>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM color AS co WHERE 1=1");
		try {
			while(rs.next()){
				Color c = new Color();
				c.setId(rs.getInt("co.id"));
				c.setcName(rs.getString("co.cName"));
				cli.add(c);
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
		return cli;
	}

}
