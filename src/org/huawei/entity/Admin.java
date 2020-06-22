package org.huawei.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private int id;
	private String aName;
	private String aPassword;
	/**
	 * 商品数量
	 */
	private int comTotal;
	/**
	 * 种类数量
	 */
	private int categoryTotal;
	/**
	 * 系列数量
	 */
	private int seriesTotal;
	/**
	 * 订单数量
	 */
	private int indentTotal;
	/**
	 * 总用户数量
	 */
	private int hUserTotal;
	/**
	 * 销售总金额数量
	 */
	private long totalPrice;
	
	
	public int gethUserTotal() {
		return hUserTotal;
	}
	public void sethUserTotal(int hUserTotal) {
		this.hUserTotal = hUserTotal;
	}
	public int getComTotal() {
		return comTotal;
	}
	public int getCategoryTotal() {
		return categoryTotal;
	}
	public int getSeriesTotal() {
		return seriesTotal;
	}
	public int getIndentTotal() {
		return indentTotal;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setComTotal(int comTotal) {
		this.comTotal = comTotal;
	}
	public void setCategoryTotal(int categoryTotal) {
		this.categoryTotal = categoryTotal;
	}
	public void setSeriesTotal(int seriesTotal) {
		this.seriesTotal = seriesTotal;
	}
	public void setIndentTotal(int indentTotal) {
		this.indentTotal = indentTotal;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	public Admin() {
		super();
	}
	public Admin(int id, String aName, String aPassword) {
		super();
		this.id = id;
		this.aName = aName;
		this.aPassword = aPassword;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", aName=" + aName + ", aPassword=" + aPassword + "]";
	}
	
}
