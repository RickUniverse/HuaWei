package org.huawei.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 套餐表
 * @author Administrator
 *
 */
public class Combo implements Serializable {
	/**
	 * 套餐id
	 */
	private int id;
	/**
	 * 套餐名称
	 */
	private String cName;
	/**
	 * 套餐价格
	 */
	private double price;
	/**
	 * 商品id
	 */
	private int commodityId;
	/**
	 * 商品对象
	 */
	private Commodity commodity;
	/**
	 * 套餐内商品表
	 */
	private List<Commodity> commodityLi;
	
	/**
	 * 优惠价格
	 */
	private double huiPrice;
	
	
	
	public Combo(String cName, double price, int commodityId, double huiPrice) {
		super();
		this.cName = cName;
		this.price = price;
		this.commodityId = commodityId;
		this.huiPrice = huiPrice;
	}
	public double getHuiPrice() {
		return huiPrice;
	}
	public void setHuiPrice(double huiPrice) {
		this.huiPrice = huiPrice;
	}
	public int getId() {
		return id;
	}
	public String getcName() {
		return cName;
	}
	public double getPrice() {
		return price;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public List<Commodity> getCommodityLi() {
		return commodityLi;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public void setCommodityLi(List<Commodity> commodityLi) {
		this.commodityLi = commodityLi;
	}
	public Combo() {
		super();
	}
	public Combo(int id, String cName, double price, int commodityId, Commodity commodity,
			List<Commodity> commodityLi) {
		super();
		this.id = id;
		this.cName = cName;
		this.price = price;
		this.commodityId = commodityId;
		this.commodity = commodity;
		this.commodityLi = commodityLi;
	}
	@Override
	public String toString() {
		return "Combo [id=" + id + ", cName=" + cName + ", price=" + price + ", commodityId=" + commodityId
				+ ", commodity=" + commodity + ", commodityLi=" + commodityLi + "]";
	}
	
	
	
}
