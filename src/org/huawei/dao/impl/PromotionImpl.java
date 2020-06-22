package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ColorDao;
import org.huawei.dao.PromotionDao;
import org.huawei.entity.Color;
import org.huawei.entity.Promotion;
import org.huawei.util.BaseDao;

/**
 * 促销实现类
 * @author Administrator
 *
 */
public class PromotionImpl extends BaseDao implements PromotionDao {
	/**
	 * 根据促销id查询
	 */
	@Override
	public Promotion selectPromotionById(int id) {
		Promotion p = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM promotion WHERE id = "+id+";");
		try {
			while(rs.next()){
				p = new Promotion(rs.getInt("id"),rs.getString("title"),rs.getString("content"));
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
		return p;
	}
	/**
	 * 根据颜色配置id查询出所有促销
	 */
	@Override
	public List<Promotion> selectPromotionByColorandConfigureId(int colorandConfigureId) {
		List<Promotion> pLi = new ArrayList<Promotion>();
		ResultSet rs = super.executeQuery(null, "SELECT p.* FROM promotionden AS pro LEFT JOIN colorandconfigure AS col ON pro.`colorandconfigureid` = col.`id` LEFT JOIN promotion AS p ON p.`id` = pro.`promotionid` WHERE col.`id` = "+colorandConfigureId+";");
		try {
			while(rs.next()){
				Promotion p = new Promotion();
				p.setContent(rs.getString("p.content"));
				p.setId(rs.getInt("p.id"));
				p.setTitle(rs.getString("p.title"));
				pLi.add(p);
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
		return pLi;
	}
	@Override
	public List<Promotion> selectAllPromotionByTitle(String title, int pageNo, int pageSize) {
		List<Promotion> pLi = new ArrayList<Promotion>();
		String sql = "SELECT * FROM promotion AS p WHERE 1=1";
		if(title!=null&&!title.equals("")){
			sql += " AND p.`title` LIKE '%"+title+"%'";
		}
		sql +=" LIMIT "+(pageNo - 1)*pageSize+" , "+pageSize+";";
		ResultSet rs = super.executeQuery(null, sql);
		try {
			while(rs.next()){
				Promotion p = new Promotion();
				p.setContent(rs.getString("p.content"));
				p.setId(rs.getInt("p.id"));
				p.setTitle(rs.getString("p.title"));
				pLi.add(p);
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
		return pLi;
	}
	@Override
	public int getTotalCount(String title) {
		int totalCount = 0;
		String sql = "SELECT count(0) as totalCount FROM promotion AS p WHERE 1=1";
		if(title!=null&&!title.equals("")){
			sql += " AND p.`title` LIKE '%"+title+"%'";
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
	public boolean addPromotion(String tit, String con) {
		return super.executeUpdate(null, "INSERT INTO promotion(title,content) VALUES('"+tit+"','"+con+"')");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deletePromotion(int proId) {
		return super.executeUpdate(null, "DELETE FROM promotion WHERE id = "+proId+"");
	}
	/**
	 * 全部促销
	 */
	@Override
	public List<Promotion> selectAllPromotionByTitle() {
		List<Promotion> pLi = new ArrayList<Promotion>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM promotion AS p WHERE 1=1");
		try {
			while(rs.next()){
				Promotion p = new Promotion();
				p.setContent(rs.getString("p.content"));
				p.setId(rs.getInt("p.id"));
				p.setTitle(rs.getString("p.title"));
				pLi.add(p);
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
		return pLi;
	}

}
