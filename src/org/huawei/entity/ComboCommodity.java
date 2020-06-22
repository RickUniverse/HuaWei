package org.huawei.entity;

import java.io.Serializable;

/**
 * �ײ�����Ʒ��
 * @author Administrator
 *
 */
public class ComboCommodity implements Serializable {
	/**
	 *�ײ�����Ʒid
	 */
	private int id;
	/**
	 * �ײ�id
	 */
	private int comboId;
	/**
	 * ��Ʒid
	 */
	private int commodityId;
	/**
	 * �ײͶ���
	 */
	private Combo combo;
	/**
	 * ��Ʒ����
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
