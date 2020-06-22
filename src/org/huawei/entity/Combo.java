package org.huawei.entity;

import java.io.Serializable;
import java.util.List;

/**
 * �ײͱ�
 * @author Administrator
 *
 */
public class Combo implements Serializable {
	/**
	 * �ײ�id
	 */
	private int id;
	/**
	 * �ײ�����
	 */
	private String cName;
	/**
	 * �ײͼ۸�
	 */
	private double price;
	/**
	 * ��Ʒid
	 */
	private int commodityId;
	/**
	 * ��Ʒ����
	 */
	private Commodity commodity;
	/**
	 * �ײ�����Ʒ��
	 */
	private List<Commodity> commodityLi;
	
	/**
	 * �Żݼ۸�
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
