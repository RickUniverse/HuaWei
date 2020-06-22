package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.CategoryDao;
import org.huawei.dao.OneMenuDao;
import org.huawei.dao.SeriesDao;
import org.huawei.dao.TwoMenuDao;
import org.huawei.entity.Category;
import org.huawei.entity.OneMenu;
import org.huawei.entity.TwoMenu;
import org.huawei.util.BaseDao;
/**
 * 一级菜单实现na
 * @author Administrator
 *
 */
public class OneMenuImpl extends BaseDao implements OneMenuDao {

	@Override
	/**
	 * 获得所有一级菜单
	 */
	public List<OneMenu> selectOneMenuByAll() {
		List<OneMenu> liom = new ArrayList<OneMenu>();
		CategoryDao cimp = new CategoryImpl(); 
		SeriesDao simp = new SeriesImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM oneMenu;");
		try {
			while(rs.next()){
				OneMenu o = new OneMenu();
				o.setId(rs.getInt("id"));
				o.setCategoryId(rs.getInt("Category"));
				Category c = cimp.selectCategoryById(rs.getInt("Category"));
				o.setCategory(c);
				o.setLiSeries(simp.selectSeriesById(rs.getInt("id")));
				liom.add(o);
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
		return liom;
	}

	@Override
	public OneMenu selectOneMenuById(int id) {
		OneMenu o = null;
		CategoryDao cimp = new CategoryImpl(); 
		TwoMenuDao tim = new TwoMenuImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM oneMenu where id = "+id+";");
		try {
			while(rs.next()){
				o = new OneMenu();
				o.setId(rs.getInt("id"));
				o.setCategoryId(rs.getInt("Category"));
				Category c = cimp.selectCategoryById(rs.getInt("Category"));
				o.setCategory(c);
				List<TwoMenu> litm = tim.selectTwoMenuById(rs.getInt("id"));
				o.setLiTwoMenu(litm);
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
		return o;
	}

}
