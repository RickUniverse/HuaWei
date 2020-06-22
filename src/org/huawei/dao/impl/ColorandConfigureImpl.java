package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ColorDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.CommodityDao;
import org.huawei.dao.ConfigureDao;
import org.huawei.dao.PromotionDao;
import org.huawei.entity.Color;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.Commodity;
import org.huawei.entity.Configure;
import org.huawei.entity.Promotion;
import org.huawei.util.BaseDao;

public class ColorandConfigureImpl extends BaseDao implements ColorandConfigureDao {
	/**
	 * 实现颜色配置接口
	 */
	@Override
	public List<ColorandConfigure> selectColorandConfigureById(int floorid) {
		List<ColorandConfigure> coli = new ArrayList<ColorandConfigure>();
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM colorandconfigure AS c LEFT JOIN floorscom AS f ON c.`id` = f.`colorandconfigureid` WHERE f.`floorsid` = "+floorid+"");
		try {
			while(rs.next()){
				ColorandConfigure c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("c.colorId"));
				c.setColor(col);
				c.setColorId(rs.getInt("c.colorId"));
				Commodity com = comimp.selectCommodityById(rs.getInt("c.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("c.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("c.configureId"));
				c.setConfigure(conf);
				c.setConfigureId(rs.getInt("c.configureId"));
				
				c.setDescs(rs.getString("c.descs"));
				c.setId(rs.getInt("c.id"));
				c.setImages(rs.getString("c.images"));
				c.setPrice(rs.getDouble("c.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("c.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("c.promotionId"));
				c.setStore(rs.getInt("c.store"));
				c.setTitle(rs.getString("title"));
				
				coli.add(c);
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
		return coli;
	}
	/**
	 * 查询商品
	 */
	@Override
	public List<ColorandConfigure> selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(
			double minPrice, double maxPrice, int categoryId, int seriseId , int configureId , String cName , int pageNo, int PageSize) {
		List<ColorandConfigure> liC = new ArrayList<ColorandConfigure>();
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		StringBuffer sql = new StringBuffer("SELECT cn.* FROM colorandconfigure AS cn INNER JOIN commodity AS com ON cn.`commodityId` = com.`id` INNER JOIN category AS cate ON com.`categoryid` = cate.`id` INNER JOIN series AS ser ON com.`seriesId` = ser.`id` INNER JOIN configure AS conf ON cn.`configureId` = conf.`id` WHERE 1=1");
		if(minPrice>=0&&maxPrice>0){
			sql.append(" AND cn.`price` >="+minPrice+" AND cn.`price` <="+maxPrice+"");
		}
		if(categoryId!=0){
			sql.append(" AND cate.`id` = "+categoryId+"");
		}
		if(seriseId!=0){
			sql.append(" AND ser.`id` = "+seriseId+"");
		}
		if(configureId!=0){
			sql.append(" AND conf.`id` = "+configureId+"");
		}
		if(cName!=null&&!cName.equals("")){
			sql.append(" AND com.`cName` LIKE '%"+cName+"%'");
		}
		sql.append(" GROUP BY com.`id` ORDER BY cn.`id` LIMIT "+(pageNo - 1) * PageSize+","+PageSize+" ;");
		ResultSet rs = super.executeQuery(null, sql.toString());
		try {
			while(rs.next()){
				ColorandConfigure c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("cn.colorId"));
				c.setColor(col);
				c.setColorId(rs.getInt("cn.colorId"));
				Commodity com = comimp.selectCommodityById(rs.getInt("cn.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("cn.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("cn.configureId"));
				c.setConfigure(conf);
				c.setConfigureId(rs.getInt("cn.configureId"));
				
				c.setDescs(rs.getString("cn.descs"));
				c.setId(rs.getInt("cn.id"));
				c.setImages(rs.getString("cn.images"));
				c.setPrice(rs.getFloat("cn.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("cn.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("cn.promotionId"));
				c.setStore(rs.getInt("cn.store"));
				c.setTitle(rs.getString("cn.title"));
				
				liC.add(c);
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
	 * 查询所有对应的数量
	 */
	@Override
	public int getTotalCount(double minPrice, double maxPrice, int categoryId, int seriseId, int configureId , String cName) {
		int totalCount = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(0) AS totalCount FROM colorandconfigure AS cn INNER JOIN commodity AS com ON cn.`commodityId` = com.`id` INNER JOIN category AS cate ON com.`categoryid` = cate.`id` INNER JOIN series AS ser ON com.`seriesId` = ser.`id` INNER JOIN configure AS conf ON cn.`configureId` = conf.`id` WHERE 1=1");
		if(minPrice>=0&&maxPrice>0){
			sql.append(" AND cn.`price` >="+minPrice+" AND cn.`price` <="+maxPrice+"");
		}
		if(categoryId>0){
			sql.append(" AND cate.`id` = "+categoryId+"");
		}
		if(seriseId>0){
			sql.append(" AND ser.`id` = "+seriseId+"");
		}
		if(configureId>0){
			sql.append(" AND conf.`id` = "+configureId+"");
		}
		if(cName!=null&&!cName.equals("")){
			sql.append(" AND com.`cName` LIKE '%"+cName+"%'");
		}
		ResultSet rs = super.executeQuery(null, sql.toString());
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
	 * 按照商品id返回第一条匹配到的数据
	 */
	@Override
	public ColorandConfigure selectColorandConfigureByCommodityId(int commodityId) {
		ColorandConfigure c = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM ColorandConfigure AS c WHERE c.`commodityId` = "+commodityId+" LIMIT 1;");
		try {
			while(rs.next()){
				c = new ColorandConfigure();
				c.setDescs(rs.getString("c.descs"));
				c.setTitle(rs.getString("c.title"));
				c.setPrice(rs.getDouble("c.price"));
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
	 * 按照颜色配置id查询到对应配置对象
	 */
	@Override
	public ColorandConfigure selectColorandConfigureByColorandConfigureId(int colorandConfigureId) {
		ColorandConfigure c = null;
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM colorandconfigure AS c WHERE c.`id` = "+colorandConfigureId+";");
		try {
			while(rs.next()){
				c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("c.colorId"));
				c.setColor(col);
				c.setColorId(rs.getInt("c.colorId"));
				Commodity com = comimp.selectCommodityById(rs.getInt("c.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("c.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("c.configureId"));
				c.setConfigure(conf);
				c.setConfigureId(rs.getInt("c.configureId"));
				
				c.setDescs(rs.getString("c.descs"));
				c.setId(rs.getInt("c.id"));
				c.setImages(rs.getString("c.images"));
				c.setPrice(rs.getDouble("c.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("c.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("c.promotionId"));
				c.setStore(rs.getInt("c.store"));
				c.setTitle(rs.getString("c.title"));
				
				c.setPromotionLi(proimp.selectPromotionByColorandConfigureId(colorandConfigureId));
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
	 * 根据颜色id跟配置id查询出啦一个颜色配置对象
	 * @param colorId
	 * @param configureId
	 * @return
	 */
	@Override
	public ColorandConfigure selectColorandConfigureByColorIdAndConfigureId(int commodityId , int colorId, int configureId) {
		ColorandConfigure c = null;
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		String sql = "SELECT * FROM colorandconfigure AS c INNER JOIN commodity AS com ON com.`id` = c.commodityId WHERE com.`id` = "+commodityId+"";
		if(colorId>0){
			sql += " AND c.colorid = "+colorId+"";
		}
		if(configureId>0){
			sql += " AND c.configureId = "+configureId+"";
		}
		sql += " LIMIT 1;";
		ResultSet rs = super.executeQuery(null,sql);
		try {
			while(rs.next()){
				c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("c.colorId"));
				c.setColor(col);
				
				if(colorId<=0){
					c.setColorId(0);
				}else{
					c.setColorId(rs.getInt("c.colorId"));
				}
				Commodity com = comimp.selectCommodityById(rs.getInt("c.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("c.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("c.configureId"));
				c.setConfigure(conf);
				
				if(configureId<=0){
					c.setConfigureId(0);
				}else{
					c.setConfigureId(rs.getInt("c.configureId"));
				}
				
				if(colorId<=0&&configureId<=0){
					c.setColorId(0);
					c.setConfigureId(0);
				}
				
				c.setDescs(rs.getString("c.descs"));
				c.setId(rs.getInt("c.id"));
				c.setImages(rs.getString("c.images"));
				c.setPrice(rs.getDouble("c.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("c.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("c.promotionId"));
				c.setStore(rs.getInt("c.store"));
				c.setTitle(rs.getString("c.title"));
				
				c.setPromotionLi(proimp.selectPromotionByColorandConfigureId(rs.getInt("c.id")));
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
	 * 后台分页查询
	 */
	@Override
	public List<ColorandConfigure> selectColorandConfigureById(String comName, int colorId, int configureId, int pageNo,
			int pageSize) {
		List<ColorandConfigure> coli = new ArrayList<ColorandConfigure>();
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		String sql = "SELECT c.* FROM colorandconfigure AS c LEFT JOIN commodity AS com ON com.`id` = c.`commodityId` WHERE 1=1 ";
		if(comName!=null&&!comName.equals("")){
			sql += " AND com.`cName` LIKE '%"+comName+"%'";
		}
		if(colorId>0){
			sql += " AND c.`colorId` = "+colorId+"";
		}
		if(configureId>0){
			sql += " AND c.`configureId` = "+configureId+"";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				ColorandConfigure c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("c.colorId"));
				c.setColor(col);
				c.setColorId(rs.getInt("c.colorId"));
				Commodity com = comimp.selectCommodityById(rs.getInt("c.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("c.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("c.configureId"));
				c.setConfigure(conf);
				c.setConfigureId(rs.getInt("c.configureId"));
				
				c.setDescs(rs.getString("c.descs"));
				c.setId(rs.getInt("c.id"));
				c.setImages(rs.getString("c.images"));
				c.setPrice(rs.getDouble("c.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("c.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("c.promotionId"));
				c.setStore(rs.getInt("c.store"));
				c.setTitle(rs.getString("title"));
				
				coli.add(c);
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
		return coli;
	}
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(String comName, int colorId, int configureId) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM colorandconfigure AS c LEFT JOIN commodity AS com ON com.`id` = c.`commodityId` WHERE 1=1";
		if(comName!=null&&!comName.equals("")){
			sql += " AND com.`cName` LIKE '%"+comName+"%'";
		}
		if(colorId>0){
			sql += " AND c.`colorId` = "+colorId+"";
		}
		if(configureId>0){
			sql += " AND c.`configureId` = "+configureId+"";
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
	public boolean addColorAndConfigure(ColorandConfigure c) {
		return super.executeUpdate(new Object[]{c.getConfigureId(),c.getColorId(),c.getStore(),c.getPrice(),c.getImages(),c.getTitle(),c.getDescs(),c.getPromotionId(),c.getCommodityId()}, "INSERT INTO colorandconfigure(configureId,colorId,store,price,images,title,descs,promotionId,commodityId) VALUES(?,?,?,?,?,?,?,?,?)");
	}
	/**
	 * 修改
	 */
	@Override 
	public boolean updateColorAndConfigure(ColorandConfigure c) {
		return super.executeUpdate(new Object[]{c.getColorId(),c.getCommodityId(),c.getConfigureId(),c.getDescs(),c.getImages(),c.getPrice(),c.getPromotionId(),c.getStore(),c.getTitle(),c.getId()}, "UPDATE colorandconfigure AS c SET c.`colorId` = ? , c.`commodityId` = ? , c.`configureId` = ? , c.`descs` = ? , c.`images` = ? , c.`price` = ? , c.`promotionId` = ? , c.`store` = ? , c.`title` = ? WHERE c.`id` = ?");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteColorAndConfigure(int couId) {
		return super.executeUpdate(null, "DELETE FROM colorandconfigure WHERE id = "+couId+"");
	}
	/**
	 * 楼层分页查询
	 */
	@Override
	public List<ColorandConfigure> selectColorandConfigureByIdByFloor(int floorId, int couId, int pageNo,
			int pageSize) {
		List<ColorandConfigure> coli = new ArrayList<ColorandConfigure>();
		ColorDao cimp = new ColorImpl();
		CommodityDao comimp = new CommodityImpl();
		ConfigureDao confimp = new ConfigureImpl();
		PromotionDao proimp = new PromotionImpl();
		String sql = "SELECT * FROM colorandconfigure AS c INNER JOIN floorscom AS f ON f.`colorandconfigureid` = c.`id` WHERE 1=1";
		if(floorId>0){
			sql += " AND f.`floorsid` = "+floorId+"";
		}
		if(couId>0){
			sql += " AND f.`colorandconfigureid` = "+couId+"";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				ColorandConfigure c = new ColorandConfigure();
				Color col = cimp.selectColorById(rs.getInt("c.colorId"));
				c.setColor(col);
				c.setColorId(rs.getInt("c.colorId"));
				Commodity com = comimp.selectCommodityById(rs.getInt("c.commodityId"));
				c.setCommodity(com);
				c.setCommodityId(rs.getInt("c.commodityId"));
				Configure conf = confimp.selectConfigureById(rs.getInt("c.configureId"));
				c.setConfigure(conf);
				c.setConfigureId(rs.getInt("c.configureId"));
				
				c.setDescs(rs.getString("c.descs"));
				c.setId(rs.getInt("c.id"));
				c.setImages(rs.getString("c.images"));
				c.setPrice(rs.getDouble("c.price"));
				Promotion pro = proimp.selectPromotionById(rs.getInt("c.promotionId"));
				c.setPromotion(pro);
				c.setPromotionId(rs.getInt("c.promotionId"));
				c.setStore(rs.getInt("c.store"));
				c.setTitle(rs.getString("title"));
				
				c.setFloorId(rs.getInt("f.floorsid"));
				c.setScormId(rs.getInt("f.id"));
				coli.add(c);
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
		return coli;
	}
	/**
	 * 获取数量
	 */
	@Override
	public int getTotalCount(int floorId, int couId) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM colorandconfigure AS c INNER JOIN floorscom AS f ON f.`colorandconfigureid` = c.`id` WHERE 1=1";
		if(floorId>0){
			sql += " AND f.`floorsid` = "+floorId+"";
		}
		if(couId>0){
			sql += " AND f.`colorandconfigureid` = "+couId+"";
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

}
