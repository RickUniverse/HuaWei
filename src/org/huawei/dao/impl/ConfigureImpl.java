package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ConfigureDao;
import org.huawei.entity.Configure;
import org.huawei.util.BaseDao;

/**
 * 配置实现类
 * @author Administrator
 *
 */
public class ConfigureImpl extends BaseDao implements ConfigureDao {
	/**
	 * 根据配置id查询
	 */
	@Override
	public Configure selectConfigureById(int id) {
		Configure c = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM Configure WHERE id = "+id+";");
		try {
			while(rs.next()){
				c = new Configure(rs.getInt("id"),rs.getString("cName"));
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
	 * 根据分类查询配置集合
	 */
	@Override
	public List<Configure> selectConfiguresByCagegoryId(int cagegoryId , int seriesId, String comName) {
		List<Configure> liC = new ArrayList<Configure>();
		StringBuffer sql = new StringBuffer("SELECT com.*,c.`id`,c.`cName`,con.`commodityId`,cate.`cName` FROM configure AS c LEFT JOIN colorandconfigure AS con ON c.`id` = con.`configureId` LEFT JOIN commodity AS com ON con.`commodityId` = com.`id` LEFT JOIN category AS cate ON cate.`id` = com.`categoryid` LEFT JOIN series AS ser ON ser.id = com.`seriesId` WHERE 1=1 ");
		if(comName!=null&&!comName.equals("")){
			sql.append(" AND com.`cName` LIKE '%"+comName+"%'");
		}else{
			if(cagegoryId>0){
				sql.append(" AND cate.`id` = "+cagegoryId+"");
			}
			if(seriesId>0){
				sql.append(" AND ser.id = "+seriesId+"");
			}
		}
		
		sql.append(" GROUP BY c.`cName`");
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				Configure con = new Configure(rs.getInt("c.id"),rs.getString("c.cName"));
				liC.add(con);
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
		return liC;
	}
	/**
	 * 根据商品id查询出该商品所拥有的的所有配置
	 */
	@Override
	public List<Configure> selectConfiguresByCommodityId(int CommodityId , int colorId) {
		List<Configure> liC = new ArrayList<Configure>();
		ConfigureDao cimp = new ConfigureImpl();
		ResultSet rs = super.executeQuery(null, "SELECT cof.* FROM configure AS cof LEFT JOIN colorandconfigure AS col ON cof.`id` = col.`configureId` WHERE col.`commodityId` = "+CommodityId+" GROUP BY cof.id;");
		try {
			while(rs.next()){
				Configure con = new Configure();
				con.setcName(rs.getString("cof.cName"));
				con.setId(rs.getInt("cof.id"));
				con.setExisit(cimp.isExisitByColorId(CommodityId, colorId, rs.getInt("cof.id")));
				liC.add(con);
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
		return liC;
	}
	/**
	 * 被上面调用，用来判断此颜色中是否包含该元素
	 */
	@Override
	public boolean isExisitByColorId(int commodityId, int colorId, int configureId) {
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
	public List<Configure> selectAllConfiguresBycName(String cName, int pageNo, int pageSize) {
		List<Configure> liC = new ArrayList<Configure>();
		String sql = "SELECT * FROM configure AS cof WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND cof.`cName` LIKE '%"+cName+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Configure con = new Configure();
				con.setcName(rs.getString("cof.cName"));
				con.setId(rs.getInt("cof.id"));
				liC.add(con);
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
		return liC;
	}
	@Override
	public int getTotalCount(String cName) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM configure AS cof WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND cof.`cName` LIKE '%"+cName+"%'";
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
	public boolean addConfigure(String confName) {
		return super.executeUpdate(null, "INSERT INTO configure(cName) VALUES('"+confName+"')");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteConfigureId(int confId) {
		return super.executeUpdate(null, "DELETE FROM configure WHERE id = "+confId+"");
	}
	/**
	 * 全部配置
	 */
	@Override
	public List<Configure> selectAllConfiguresBycName() {
		List<Configure> liC = new ArrayList<Configure>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM configure AS cof WHERE 1=1");
		try {
			while(rs.next()){
				Configure con = new Configure();
				con.setcName(rs.getString("cof.cName"));
				con.setId(rs.getInt("cof.id"));
				liC.add(con);
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
		return liC;
	}

}
