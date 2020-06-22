package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.CategoryDao;
import org.huawei.entity.Category;
import org.huawei.util.BaseDao;

/**
 * 种类实现类
 * @author Administrator
 *
 */
public class CategoryImpl extends BaseDao implements CategoryDao {

	@Override
	/**
	 * 获得种类对象
	 * @param id 种类id
	 * @return
	 */
	public Category selectCategoryById(int categoryid) {
		Category c = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM category WHERE id = "+categoryid+";");
		try {
			while(rs.next()){
				c = new Category(rs.getInt("id"),rs.getString("cName"));
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
	 * 根据细分查询
	 */
	@Override
	public Category selectCategoryBySeriesId(int seriesId) {
		Category cate = null;
		ResultSet rs = super.executeQuery(null, "SELECT  c.`id`,c.`cName` FROM category AS c LEFT JOIN series AS s ON c.`id` = s.`categoryId` WHERE s.`id` = "+seriesId+";");
		try {
			while(rs.next()){
				cate = new Category(rs.getInt("c.id"),rs.getString("c.cName"));
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
		return cate;
	}
	/**
	 * 查询出所有分类
	 */
	@Override
	public List<Category> selectAllCategory(String sName  , int pageNo , int pageSize) {
		List<Category> cLi = new ArrayList<Category>();
		String sql = "SELECT * FROM category WHERE 1=1";
		if(sName!=null&&!sName.equals("")){
			sql += " AND cName LIKE '%"+sName+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				cLi.add(new Category(rs.getInt("id"),rs.getString("cName")));
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
		return cLi;
	}
	@Override
	public boolean addCategory(Category category) {
		return super.executeUpdate(new Object[]{category.getsName()}, "INSERT INTO category(cName) VALUES(?)");
	}
	/**
	 * 根据种类id删除种类
	 * @param categoryId
	 * @return
	 */
	@Override
	public boolean deleteCategoryByCategoryId(int categoryId) {
		return super.executeUpdate(null, "DELETE FROM category WHERE id = "+categoryId+"");
	}
	@Override
	public int getTotalCount(String sName) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM category WHERE 1=1";
		if(sName!=null&&!sName.equals("")){
			sql += " AND cName LIKE '%"+sName+"%'";
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
	/**
	 * 查询所有分类
	 */
	@Override
	public List<Category> selectAllCategory() {
		List<Category> cLi = new ArrayList<Category>();
		String sql = "SELECT * FROM category WHERE 1=1";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				cLi.add(new Category(rs.getInt("id"),rs.getString("cName")));
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
		return cLi;
	}
	
}
