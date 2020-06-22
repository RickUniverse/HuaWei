package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.CarouselDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.entity.Carousel;
import org.huawei.util.BaseDao;

public class CarouselImpl extends BaseDao implements CarouselDao {
	/**
	 * 实现获取所有轮播
	 */
	@Override
	public List<Carousel> selectAllCarousel() {
		List<Carousel> caLi = new ArrayList<Carousel>();
		ColorandConfigureDao cImp = new ColorandConfigureImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM carousel ORDER BY orders;");
		try {
			while(rs.next()){
				caLi.add(new Carousel(rs.getInt("id"),rs.getString("image"),rs.getString("href"),rs.getInt("Colorandconfigureid"),cImp.selectColorandConfigureByColorandConfigureId(rs.getInt("Colorandconfigureid")),rs.getInt("orders")));
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
		return caLi;
	}
	/**
	 * 添加轮播
	 */
	@Override
	public boolean AddCarousel(Carousel c) {
		return super.executeUpdate(new Object[]{c.getImage(),c.getHref(),c.getColorandconfigureId(),c.getOrders()}, "INSERT INTO carousel(Image,href,Colorandconfigureid,orders) VALUES(?,?,?,?)");
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateCarousel(String href, int orders , int carId) {
		return super.executeUpdate(null, "UPDATE carousel AS c SET c.`href` = '"+href+"' , c.`orders`  = "+orders+" WHERE c.`id` = "+carId+"");
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteCarousel(int carId) {
		return super.executeUpdate(null, "DELETE FROM carousel WHERE id = "+carId+"");
	}

}
