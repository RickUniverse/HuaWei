package org.huawei.entity;

import java.io.Serializable;

/**
 * 套餐内商品表
 * @author Administrator
 *
 */
public class ComboCommodity implements Serializable {
	/**
	 *套餐内商品id
	 */
	private int id;
	/**
	 * 套餐id
	 */
	private int comboId;
	/**
	 * 商品id
	 */
	private int commodityId;
	/**
	 * 套餐对象
	 */
	private Combo combo;
	/**
	 * 商品对象
	 */
	private Commodity commodity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComboId() {
		return comboId;
	}
	public void setComboId(int comboId) {
		this.comboId = comboId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public ComboCommodity() {
		super();
	}
	public ComboCommodity(int id, int comboId, int commodityId, Combo combo, Commodity commodity) {
		super();
		this.id = id;
		this.comboId = comboId;
		this.commodityId = commodityId;
		this.combo = combo;
		this.commodity = commodity;
	}
	@Override
	public String toString() {
		return "ComboCommodity [id=" + id + ", comboId=" + comboId + ", commodityId=" + commodityId + ", combo=" + combo
				+ ", commodity=" + commodity + "]";
	}
	
	
}
