package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.CategoryDao;
import org.huawei.dao.SeriesDao;
import org.huawei.entity.Category;
import org.huawei.entity.Series;
import org.huawei.util.BaseDao;

/**
 * 细分实现类
 * @author Administrator
 *
 */
public class SeriesImpl extends BaseDao implements SeriesDao {

	/**
	 * 根据一级菜单id获取集合
	 */
	@Override
	public List<Series> selectSeriesById(int onemenuid) {
		List<Series> lis = new ArrayList<Series>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM twomenu AS t INNER JOIN series AS s ON t.`seriesid` = s.`id` WHERE t.`oneMenuid` = "+onemenuid+"");
		try {
			while(rs.next()){
				Series s = new Series();
				s.setCategoryId(rs.getInt("s.categoryId"));
				s.setId(rs.getInt("s.id"));
				s.setImage(rs.getString("s.image"));
				s.setsName(rs.getString("s.sName"));
				lis.add(s);
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
		return lis;
	}

	@Override
	public List<Series> selectSeriesByCategoryId(int categoryId) {
		List<Series> lis = new ArrayList<Series>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM series AS s WHERE s.`categoryId` = "+categoryId+"");
		try {
			while(rs.next()){
				Series s = new Series();
				s.setCategoryId(rs.getInt("s.categoryId"));
				s.setId(rs.getInt("s.id"));
				s.setImage(rs.getString("s.image"));
				s.setsName(rs.getString("s.sName"));
				lis.add(s);
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
		return lis;
	}

	@Override
	public Series selectOneSeriesById(int id) {
		Series s = null;
		CategoryDao catImp = new CategoryImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM series AS s WHERE s.`id` = "+id+";");
		try {
			while(rs.next()){
				s = new Series();
				s.setCategoryId(rs.getInt("s.categoryId"));
				s.setId(rs.getInt("s.id"));
				s.setImage(rs.getString("s.image"));
				s.setsName(rs.getString("s.sName"));
				s.setCategory(catImp.selectCategoryById(rs.getInt("s.categoryId")));
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
		return s;
	}
	/**
	 * 查询所有系列
	 * @return
	 */
	@Override
	public List<Series> selectAllSeries(String serName , int categoryId , int pageNo , int pageSize) {
		List<Series> lis = new ArrayList<Series>();
		CategoryDao cImp = new CategoryImpl();
		String sql = "SELECT * FROM series AS s WHERE 1=1";
		if(serName!=null&&!serName.equals("")){
			sql += " AND s.`sName` LIKE '%"+serName+"%'";
		}
		if(categoryId>0){
			sql += " AND s.`categoryId` = "+categoryId+"";
		}
		sql += " LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Series s = new Series();
				s.setCategoryId(rs.getInt("s.categoryId"));
				s.setId(rs.getInt("s.id"));
				s.setImage(rs.getString("s.image"));
				s.setsName(rs.getString("s.sName"));
				s.setReCommodityCount(getReCommodityCount(rs.getInt("s.id")));
				s.setCategory(cImp.selectCategoryById(rs.getInt("s.categoryId")));
				lis.add(s);
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
		return lis;
	}
	/**
	 * 根据细分id查询出该细分所关联的商品数量
	 * @param seriesId
	 * @return
	 */
	@Override
	public int getReCommodityCount(int seriesId) {
		int totalCount = 0;
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS totalCount FROM commodity AS com WHERE com.`seriesId` = "+seriesId+"");
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
	/**
	 * 添加细分
	 * @param ser
	 * @return
	 */
	@Override
	public boolean addSeries(Series ser) {
		return super.executeUpdate(new Object[]{ser.getsName(),ser.getImage(),ser.getCategoryId()}, "INSERT INTO series(sName,image,categoryId) VALUES(?,?,?)");
	}
	/**
	 * 修改细分
	 */
	@Override
	public boolean updateSeries(int seriesId, String sName, int categoryId) {
		return super.executeUpdate(null, "UPDATE series SET sName='"+sName+"' ,categoryId = "+categoryId+" WHERE id = "+seriesId+" ;");
	}
	/**
	 * 按照细分id删除该细分
	 * @param seriesId
	 * @return
	 */
	@Override
	public boolean deleteSeriesBySeriesId(int seriesId) {
		return super.executeUpdate(null, "DELETE FROM series WHERE id = "+seriesId+"");
	}
	/**
	 * 获取总数量
	 */
	@Override
	public int totalCount(String serName, int categoryId) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM series AS s WHERE 1=1";
		if(serName!=null&&!serName.equals("")){
			sql += " AND s.`sName` LIKE '%"+serName+"%'";
		}
		if(categoryId>0){
			sql += " AND s.`categoryId` = "+categoryId+"";
		}
		ResultSet rs = super.executeQuery(null, sql);
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
	public List<Series> selectAllSeries() {
		List<Series> lis = new ArrayList<Series>();
		CategoryDao cImp = new CategoryImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM series AS s WHERE 1=1");
		try {
			while(rs.next()){
				Series s = new Series();
				s.setCategoryId(rs.getInt("s.categoryId"));
				s.setId(rs.getInt("s.id"));
				s.setImage(rs.getString("s.image"));
				s.setsName(rs.getString("s.sName"));
				s.setReCommodityCount(getReCommodityCount(rs.getInt("s.id")));
				s.setCategory(cImp.selectCategoryById(rs.getInt("s.categoryId")));
				lis.add(s);
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
		return lis;
	}
}
