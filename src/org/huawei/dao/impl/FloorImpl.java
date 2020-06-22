package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.CategoryDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.CommodityDao;
import org.huawei.dao.FloorDao;
import org.huawei.dao.SeriesDao;
import org.huawei.entity.Category;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.Commodity;
import org.huawei.entity.Floor;
import org.huawei.entity.Series;
import org.huawei.util.BaseDao;

/**
 * 楼层是想类
 * @author Administrator
 *
 */
public class FloorImpl extends BaseDao implements FloorDao {
	/**
	 * 实现获取所有楼层
	 */
	@Override
	public List<Floor> selectFloorByAll() {
		List<Floor> fLi = new ArrayList<Floor>();
		
		CategoryDao cateimp = new CategoryImpl();
		SeriesDao serimp = new SeriesImpl();
		ColorandConfigureDao conimp = new ColorandConfigureImpl();
		CommodityDao comimp = new CommodityImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM floors;");
		try {
			while(rs.next()){
				Floor f = new Floor();
				f.setId(rs.getInt("id"));
				f.setCategoryId(rs.getInt("categoryid"));
				Category cate = cateimp.selectCategoryById(rs.getInt("categoryid"));
				f.setCategory(cate);
				
				List<Series> liS = serimp.selectSeriesByCategoryId(rs.getInt("categoryid"));
				f.setLiSeries(liS);
				List<ColorandConfigure> coLi = conimp.selectColorandConfigureById(rs.getInt("id"));
				f.setLiColorandConfigure(coLi);
				/*List<Commodity> liC = comimp.selectCommodityByFloorId(rs.getInt("id"));
				f.setLiCommodity(liC);*/
				fLi.add(f);
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
		return fLi;
	}
	/**
	 * 添加楼层
	 */
	@Override
	public boolean addFloorScom(int flId, int couId) {
		return super.executeUpdate(null, "INSERT INTO floorscom(floorsid,colorandconfigureid) VALUES("+flId+","+couId+")");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean removeFloorScom(int ScomId) {
		return super.executeUpdate(null, "DELETE FROM floorscom WHERE id = "+ScomId+"");
	}

}
