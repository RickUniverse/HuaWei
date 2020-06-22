package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.ComboDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.ShoppingCartDao;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.ShoppingCart;
import org.huawei.util.BaseDao;

public class ShoppingCartImpl extends BaseDao implements ShoppingCartDao {
	/**
	 * ʵ�������Ʒ�����ﳵ
	 */
	@Override
	public boolean addShoppingCart(int colorAndConfigureId, int total, double totalPrice, int comboId, int huserid) {
		
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS isExisit,s.`total`,s.`id`,s.`totalPrice`,col.`price`,col.`store` FROM shoppingcart AS s INNER JOIN colorandconfigure AS col ON col.`id` = s.`colorAndConfigureId` WHERE s.`huserid` = "+huserid+" AND col.`id` = "+colorAndConfigureId+"");
		boolean isOk = false;
		try {
			while(rs.next()){
				if(rs.getInt("isExisit")>0){
					if(rs.getInt("s.total") < rs.getInt("col.store")){
						isOk = super.executeUpdate(new Object[]{(rs.getDouble("s.totalPrice")+rs.getDouble("col.price")),(rs.getInt("s.total")+1),rs.getInt("s.id")}, "UPDATE shoppingcart AS s SET s.`totalPrice` = ? , s.`total` = ? WHERE s.`id` = ?");
					}else{
						isOk = false;
					}
				}else{
					isOk = super.executeUpdate(new Object[]{colorAndConfigureId,total,totalPrice,false,comboId,huserid}, "INSERT INTO shoppingcart(colorAndConfigureId,total,totalPrice,checked,comboId,huserid) VALUES(?,?,?,?,?,?);");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOk;
	}
	/**
	 * ��ѯ�����û����ﳵ�ڵ�������Ʒ
	 */
	@Override
	public List<ShoppingCart> selectAllShoppingCartByUserId(int hUserId) {
		List<ShoppingCart> spLi = new ArrayList<ShoppingCart>();
		
		ColorandConfigureDao colimp = new ColorandConfigureImpl();
		ComboDao comImp = new ComboImpl();
		HUserDao huImp = new HUserImpl();
		
		ResultSet rs = super.executeQuery(null, "SELECT * FROM shoppingcart WHERE huserid = "+hUserId+";");
		try {
			while(rs.next()){
				ShoppingCart s = new ShoppingCart();
				s.setChecked(rs.getBoolean("checked"));
				s.setColorAndConfigureId(rs.getInt("colorAndConfigureId"));
				s.setComboId(rs.getInt("comboId"));
				s.setHuserId(rs.getInt("huserid"));
				s.setId(rs.getInt("id"));
				s.setTotal(rs.getInt("total"));
				s.setTotalPrice(rs.getDouble("totalPrice"));
				
				s.setColorandConfigure(colimp.selectColorandConfigureByColorandConfigureId(rs.getInt("colorAndConfigureId")));
				s.setCombo(comImp.selectOneComboByComboId(rs.getInt("comboId")));
				s.sethUser(huImp.selectHUserById(rs.getInt("huserid")));
				spLi.add(s);
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
		return spLi;
	}
	/**
	 * ʵ�ֲ�ѯ����ѡ����Ʒ�ļ۸�
	 */
	@Override
	public double selectTotalPrice(int HUserId) {
		double totalPrice = 0;
		ResultSet rs = super.executeQuery(null, "SELECT s.`totalPrice` FROM shoppingcart AS s WHERE s.`checked` = 1 AND s.`huserid` = "+HUserId+"");
		try {
			while(rs.next()){
				totalPrice += rs.getDouble("s.totalPrice");
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
		return Double.parseDouble(new DecimalFormat(".00").format(totalPrice));
	}
	/**
	 * ʵ�ֲ�ѯ����ѡ�е���Ʒ
	 */
	@Override
	public int selectTotalCheck(int HUserId) {
		int totalCheck = 0;
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS totalCheck FROM shoppingcart AS s WHERE s.`checked` = 1 AND s.`huserid` = "+HUserId+"");
		try {
			while(rs.next()){
				totalCheck = rs.getInt("totalCheck");
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
		return totalCheck;
	}
	@Override
	public double selectYouPrice(int HUserId) {
		double youPrice = 0;
		ResultSet rs = super.executeQuery(null, "SELECT c.`huiPrice` FROM shoppingcart AS s INNER JOIN combo AS c ON c.`id` = s.`comboId` WHERE s.`checked` = 1 AND s.`huserid` = "+HUserId+"");
		try {
			while(rs.next()){
				youPrice += rs.getDouble("c.huiPrice");
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
		return Double.parseDouble(new DecimalFormat(".00").format(youPrice));
	}
	/**
	 * �޸���Ʒѡ��״̬
	 */
	@Override
	public boolean updateShoppingCartCheckedByShoppingCartId(int shoppingCartId, boolean isChecked) {
		return super.executeUpdate(null, "UPDATE shoppingcart AS s SET s.`checked` = "+isChecked+" WHERE s.`id` = "+shoppingCartId+" ");
	}
	/**
	 * �޸���Ʒѡ��״̬
	 */
	@Override
	public boolean updateShoppingCartCheckedByHUserId(int hUserId, boolean isChecked) {
		return super.executeUpdate(null, "UPDATE shoppingcart AS s SET s.`checked` = "+isChecked+" WHERE s.`huserid` = "+hUserId+" ");
	}
	/**
	 * ���ݹ��ﳵidɾ����Ӧ��Ʒ
	 */
	@Override
	public boolean deleteShoppingCartByShoppingCartId(int shoppingCartId) {
		return super.executeUpdate(null, "DELETE FROM shoppingcart WHERE id = "+shoppingCartId+"");
	}
	/**
	 * ����������۸񲢷����������
	 */
	@Override
	public ShoppingCart updateNumberByShoppingCartId(boolean issubstartAndAdd, int shoppingCartId) {
		
		ShoppingCartDao scImp = new ShoppingCartImpl();
		ShoppingCart shopingcart = scImp.selectOneShoppingCartByShoppingCartId(shoppingCartId);
		
		if(issubstartAndAdd&&shopingcart.getTotal() < shopingcart.getColorandConfigure().getStore()){
			shopingcart.setTotal(shopingcart.getTotal() + 1);
			shopingcart.setTotalPrice( Double.parseDouble(new DecimalFormat(".00").format(shopingcart.getTotalPrice() + shopingcart.getColorandConfigure().getPrice()))     );
		}else if(issubstartAndAdd==false&&shopingcart.getTotal() > 1){
			shopingcart.setTotal(shopingcart.getTotal() - 1);
			shopingcart.setTotalPrice(Double.parseDouble(new DecimalFormat(".00").format(shopingcart.getTotalPrice() - shopingcart.getColorandConfigure().getPrice()))     );
		}
		super.executeUpdate(null, "UPDATE shoppingcart AS s SET s.`totalPrice` = "+shopingcart.getTotalPrice()+" , s.`total` = "+shopingcart.getTotal()+" WHERE s.`id` = "+shoppingCartId+" ");
		return shopingcart;
	}
	@Override
	public ShoppingCart selectOneShoppingCartByShoppingCartId(int shoppingCartId) {
		ShoppingCart s = new ShoppingCart();
		
		ColorandConfigureDao colimp = new ColorandConfigureImpl();
		ComboDao comImp = new ComboImpl();
		HUserDao huImp = new HUserImpl();
		
		ResultSet rs = super.executeQuery(null, "SELECT * FROM shoppingcart AS s WHERE s.`id` = "+shoppingCartId+";");
		try {
			while(rs.next()){
				s = new ShoppingCart();
				s.setChecked(rs.getBoolean("checked"));
				s.setColorAndConfigureId(rs.getInt("colorAndConfigureId"));
				s.setComboId(rs.getInt("comboId"));
				s.setHuserId(rs.getInt("huserid"));
				s.setId(rs.getInt("id"));
				s.setTotal(rs.getInt("total"));
				s.setTotalPrice(rs.getDouble("totalPrice"));
				
				s.setColorandConfigure(colimp.selectColorandConfigureByColorandConfigureId(rs.getInt("colorAndConfigureId")));
				s.setCombo(comImp.selectOneComboByComboId(rs.getInt("comboId")));
				s.sethUser(huImp.selectHUserById(rs.getInt("huserid")));
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
	 * ʵ�ֲ�ѯѡ����Ʒ������
	 */
	@Override
	public int getCheckedShoppingCartTotalByHUserId(int huserId) {
		int checkedCount = 0;
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS checkedCount FROM shoppingcart AS s WHERE s.`huserid` = "+huserId+" AND s.`checked` = 1;");
		try {
			while(rs.next()){
				checkedCount = rs.getInt("checkedCount");
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
		return checkedCount;
	}
	/**
	 * ��ѯ�������Ѿ�ѡ�е���Ʒ
	 */
	@Override
	public List<ShoppingCart> selectAllCheckedByHUserId(int huserId) {
		List<ShoppingCart> spLi = new ArrayList<ShoppingCart>();
		
		ColorandConfigureDao colimp = new ColorandConfigureImpl();
		ComboDao comImp = new ComboImpl();
		HUserDao huImp = new HUserImpl();
		
		ResultSet rs = super.executeQuery(null, "SELECT * FROM shoppingcart WHERE huserid = "+huserId+" AND checked = 1;");
		try {
			while(rs.next()){
				ShoppingCart s = new ShoppingCart();
				s.setChecked(rs.getBoolean("checked"));
				s.setColorAndConfigureId(rs.getInt("colorAndConfigureId"));
				s.setComboId(rs.getInt("comboId"));
				s.setHuserId(rs.getInt("huserid"));
				s.setId(rs.getInt("id"));
				s.setTotal(rs.getInt("total"));
				s.setTotalPrice(rs.getDouble("totalPrice"));
				
				s.setColorandConfigure(colimp.selectColorandConfigureByColorandConfigureId(rs.getInt("colorAndConfigureId")));
				s.setCombo(comImp.selectOneComboByComboId(rs.getInt("comboId")));
				s.sethUser(huImp.selectHUserById(rs.getInt("huserid")));
				spLi.add(s);
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
		return spLi;
	}
	/**
	 * ɾ������ѡ�еĹ��ﳵ
	 */
	@Override
	public boolean deleteAllChecked(int hUserId) {
		return super.executeUpdate(null, "DELETE FROM shoppingcart WHERE huserid = "+hUserId+" AND checked = 1");
	}

	
	
	
}
