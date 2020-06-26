package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.OneMenuDao;
import org.huawei.dao.SeriesDao;
import org.huawei.dao.TwoMenuDao;
import org.huawei.entity.OneMenu;
import org.huawei.entity.Series;
import org.huawei.entity.TwoMenu;
import org.huawei.util.BaseDao;
/**
 * 二级菜单实现
 * @author Administrator
 *
 */
public class TwoMenuImpl extends BaseDao implements TwoMenuDao {

	@Override
	/**
	 * 根据id获取二级菜单集合
	 */
	public List<TwoMenu> selectTwoMenuById(int onemenuid) {
		List<TwoMenu> litm = new ArrayList<TwoMenu>();
		SeriesDao simp = new SeriesImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM twomenu WHERE oneMenuid = "+onemenuid+"");
		try {
			while(rs.next()){
				TwoMenu t = new TwoMenu();
				t.setId(rs.getInt("id"));
				t.setSeriesid(rs.getInt("seriesid"));
				t.setOneMenuid(rs.getInt("oneMenuid"));
				List<Series> lis = simp.selectSeriesById(rs.getInt("oneMenuid"));
				t.setLiSeries(lis);
				
				litm.add(t);
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
		return litm;
	}

	@Override
	public TwoMenu selectOneTwoMenuById(int onemenuid) {
		TwoMenu t = null;
		List<Series> lis = new ArrayList();
		/*SeriesDao simp = new SeriesImpl();*/
		ResultSet rs = super.executeQuery(null, "SELECT * FROM twomenu AS t INNER JOIN series AS s ON t.`seriesid` = s.`id` WHERE oneMenuid = "+onemenuid+"");
		try {
			while(rs.next()){
				t = new TwoMenu();
				t.setId(rs.getInt("id"));
				t.setSeriesid(rs.getInt("seriesid"));
				t.setOneMenuid(rs.getInt("oneMenuid"));
				
				t.setLiSeries(lis);
				
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
		return null;
	}

}
