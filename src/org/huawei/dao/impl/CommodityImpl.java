package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.huawei.dao.CategoryDao;
import org.huawei.dao.ColorDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.ComboDao;
import org.huawei.dao.CommodityDao;
import org.huawei.dao.ConfigureDao;
import org.huawei.dao.SeriesDao;
import org.huawei.entity.Category;
import org.huawei.entity.Color;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.Commodity;
import org.huawei.entity.Configure;
import org.huawei.entity.Series;
import org.huawei.util.BaseDao;

/**
 * 商品实现类
 * @author Administrator
 *
 */
public class CommodityImpl extends BaseDao implements CommodityDao {
	/**
	 * 实现根据楼层查询商品
	 */
	@Override
	public List<Commodity> selectCommodityByFloorId(int floorId) {
		List<Commodity> cLi = new ArrayList<Commodity>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM floorscom AS f LEFT JOIN commodity AS c ON f.`commodityid` = c.`id` WHERE f.`floorsid` = "+floorId+";");
		try {
			while(rs.next()){
				Commodity c = new Commodity();
				c.setId(rs.getInt("c.id"));
				c.setImage(rs.getString("c.image"));
				c.setcName(rs.getString("c.cName"));
				c.setPutawayTime(rs.getDate("c.putawayTime"));
				c.setCategoryId(rs.getInt("c.categoryId"));
				c.setSeriesId(rs.getInt("c.seriesId"));
				
				cLi.add(c);
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
	/**
	 * 查询单个商品
	 */
	@Override
	public Commodity selectCommodityById(int id) {
		Commodity c = null;
		CategoryDao cateimp = new CategoryImpl();
		SeriesDao serimp = new SeriesImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM Commodity WHERE id ="+id+";");
		try {
			while(rs.next()){
				c = new Commodity();
				Category cate = cateimp.selectCategoryById(rs.getInt("categoryid"));
				c.setCategory(cate);
				c.setCategoryId(rs.getInt("categoryid"));
				
				c.setcName(rs.getString("cName"));
				c.setId(rs.getInt("id"));
				c.setImage(rs.getString("image"));
				c.setPutawayTime(rs.getDate("putawayTime"));
				Series s = serimp.selectOneSeriesById(rs.getInt("seriesId"));
				c.setSeries(s);
				c.setSeriesId(rs.getInt("seriesId"));
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
	 * 根据颜色配置查询到对应的商品对象
	 * 颜色配置对应的商品
	 * 实现按照颜色配置查询商品的功能
	 */
	@Override
	public Commodity selectCommodityByColorandConfigureId(int colorandConfigureId) {//方法完成
		Commodity c = null;
		ColorandConfigureDao coldimp = new ColorandConfigureImpl();
		CategoryDao cateimp = new CategoryImpl();
		ColorDao colorimp = new ColorImpl();
		SeriesDao serimp = new SeriesImpl();
		ComboDao combimp = new ComboImpl();
		ConfigureDao confimp = new ConfigureImpl();
		ResultSet rs = super.executeQuery(null, "SELECT com.* FROM commodity AS com INNER JOIN colorandconfigure AS cou ON com.`id` = cou.`commodityId` WHERE cou.`id` = "+colorandConfigureId+";");
		try {
			while(rs.next()){
				c = new Commodity();
				Category cate = cateimp.selectCategoryById(rs.getInt("com.categoryid"));
				c.setCategory(cate);
				c.setCategoryId(rs.getInt("com.categoryid"));
				c.setcName(rs.getString("com.cName"));
				c.setId(rs.getInt("com.id"));
				c.setImage(rs.getString("com.image"));
				c.setPutawayTime(rs.getDate("com.putawayTime"));
				Series s = serimp.selectOneSeriesById(rs.getInt("com.seriesId"));
				c.setSeries(s);
				c.setSeriesId(rs.getInt("com.seriesId"));
				
				//页面当前选中，颜色配置对象
				ColorandConfigure colu = coldimp.selectColorandConfigureByColorandConfigureId(colorandConfigureId);
				List<Color> colLi = colorimp.selectColorByCommodityId(rs.getInt("com.id"),colu.getConfigureId());
				List<Configure> conLi = confimp.selectConfiguresByCommodityId(rs.getInt("com.id"),colu.getColorId());
				
				c.setColorLi(colLi);
				c.setConfigureLi(conLi);
				
				
				c.setComboLi(combimp.selectComboByCommodityId(rs.getInt("com.id")));
				c.setColorandConfigure(colu);
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
	 * 套餐内包含的商品
	 * 根据套餐id获取套餐内的商品
	 */
	@Override
	public List<Commodity> selectCommodityByCommId(int CommId) {
		List<Commodity> cLi = new ArrayList<Commodity>();
		ColorandConfigureDao cimp = new ColorandConfigureImpl();
		ResultSet rs = super.executeQuery(null, "SELECT comd.* FROM combo AS com LEFT JOIN combocommodity AS cc ON com.`id` = cc.`Comboid` LEFT JOIN commodity AS comd ON cc.`Commodityid` = comd.`id` WHERE com.`id` = "+CommId+";");
		try {
			while(rs.next()){
				Commodity c = new Commodity();
				c.setId(rs.getInt("comd.id"));
				c.setImage(rs.getString("comd.image"));
				c.setcName(rs.getString("comd.cName"));
				c.setPutawayTime(rs.getDate("comd.putawayTime"));
				c.setCategoryId(rs.getInt("comd.categoryId"));
				c.setSeriesId(rs.getInt("comd.seriesId"));
				c.setColorandConfigure(cimp.selectColorandConfigureByCommodityId(rs.getInt("comd.id")));
				cLi.add(c);
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
	/**
	 * 商品id用来指定查询哪一个商品内的颜色配置
	 * 按照颜色id跟配置id查询出商品的颜色配置
	 * @param commodityId//商品id用来指定是哪一个商品
	 * @param colorId//判断配置跟颜色的关系
	 * @param configureId//判断颜色跟配置的关系
	 * @param comboId//用来控制当前商品选中的套餐
	 * @return
	 */
	@Override
	public Commodity selectCommodityByCommodityIdAndColorIdAndConfigureId(int commodityId, int colorId, int configureId,
			int comboId) {
		Commodity c = null;
		ColorandConfigureDao coldimp = new ColorandConfigureImpl();
		CategoryDao cateimp = new CategoryImpl();
		ColorDao colorimp = new ColorImpl();
		SeriesDao serimp = new SeriesImpl();
		ComboDao combimp = new ComboImpl();
		ConfigureDao confimp = new ConfigureImpl();
		//状态：
		//1.颜色未选中，配置有值。需要修改颜色中的exisit值，需要循环颜色，是否有跟当前配置id,有则为true，无则false
		//2.配置未选中，颜色有值，需要修改配置中的exisit值，需要循环配置，是否有当前颜色id，有则为true，无则false
		//3.都未选中，颜色跟配置都为true
		ResultSet rs = super.executeQuery(null, "SELECT * FROM commodity AS com WHERE com.`id` = "+commodityId+";");
		try {
			while(rs.next()){
				c = new Commodity();
				Category cate = cateimp.selectCategoryById(rs.getInt("com.categoryid"));
				c.setCategory(cate);
				c.setCategoryId(rs.getInt("com.categoryid"));
				c.setcName(rs.getString("com.cName"));
				c.setId(rs.getInt("com.id"));
				c.setImage(rs.getString("com.image"));
				c.setPutawayTime(rs.getDate("com.putawayTime"));
				Series s = serimp.selectOneSeriesById(rs.getInt("com.seriesId"));
				c.setSeries(s);
				c.setSeriesId(rs.getInt("com.seriesId"));
				
				//页面当前选中，颜色配置对象
				ColorandConfigure colu = coldimp.selectColorandConfigureByColorIdAndConfigureId(commodityId, colorId, configureId);
				
				List<Color> colLi = colorimp.selectColorByCommodityId(commodityId,colu.getConfigureId());//现在这个第二个参数可以省略了，反正只要第二个参数为0，就全部为false，因为还是会进行修改isexisit所以加上也无所谓
				
				List<Configure> conLi = confimp.selectConfiguresByCommodityId(commodityId,colu.getColorId());//现在这个第二个参数可以省略了，反正只要第二个参数为0，就全部为false，因为还是会进行修改isexisit所以加上也无所谓

				c.setColorLi(colLi);
				c.setConfigureLi(conLi);
				
				c.setComboId(comboId);
				
				c.setComboLi(combimp.selectComboByCommodityId(rs.getInt("com.id")));
				c.setColorandConfigure(colu);
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
	 * 分页查询
	 */
	@Override
	public List<Commodity> selectAllCommodityBycNameAndSeriesId(String cName, int seriesId, int pageNo, int pageSize) {
		List<Commodity> cLi = new ArrayList<Commodity>();
		SeriesDao serimp = new SeriesImpl();
		String sql = "SELECT * FROM commodity AS comd WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND comd.`cName` LIKE '%"+cName+"%'";
		}
		if(seriesId>0){
			sql += " AND comd.`seriesId` = "+seriesId+"";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Commodity c = new Commodity();
				c.setId(rs.getInt("comd.id"));
				c.setImage(rs.getString("comd.image"));
				c.setcName(rs.getString("comd.cName"));
				c.setPutawayTime(rs.getDate("comd.putawayTime"));
				c.setCategoryId(rs.getInt("comd.categoryId"));
				c.setSeriesId(rs.getInt("comd.seriesId"));
				c.setSeries(serimp.selectOneSeriesById(rs.getInt("comd.seriesId")));
				cLi.add(c);
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
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(String cName,int seriesId) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM commodity AS comd WHERE 1=1";
		if(cName!=null&&!cName.equals("")){
			sql += " AND comd.`cName` LIKE '%"+cName+"%'";
		}
		if(seriesId>0){
			sql += " AND comd.`seriesId` = "+seriesId+"";
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
	 * 添加商品
	 */
	@Override
	public boolean addCommodity(Commodity com) {
		return super.executeUpdate(new Object[]{com.getcName(),com.getCategoryId(),com.getSeriesId(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),com.getImage()}, "INSERT INTO commodity(cName,categoryid,seriesId,putawayTime,image) VALUES(?,?,?,?,?)");
	}
	/**
	 * 删除商品
	 */
	@Override
	public boolean deleteCommodityByComId(int comId) {
		return super.executeUpdate(null, "DELETE FROM commodity WHERE id = "+comId+"");
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateCommodity(Commodity com) {
		return super.executeUpdate(new Object[]{com.getcName(),com.getCategoryId(),com.getSeriesId(),com.getImage(),com.getId()}, "UPDATE commodity SET cName = ? , categoryid = ? , seriesId = ? ,image = ? WHERE id = ?");
	}
	/**
	 * 查询所有商品
	 */
	@Override
	public List<Commodity> selectAllCommodity() {
		List<Commodity> cLi = new ArrayList<Commodity>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM commodity AS c;");
		try {
			while(rs.next()){
				Commodity c = new Commodity();
				c.setId(rs.getInt("c.id"));
				c.setImage(rs.getString("c.image"));
				c.setcName(rs.getString("c.cName"));
				c.setPutawayTime(rs.getDate("c.putawayTime"));
				c.setCategoryId(rs.getInt("c.categoryId"));
				c.setSeriesId(rs.getInt("c.seriesId"));
				
				cLi.add(c);
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
