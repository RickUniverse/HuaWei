package org.huawei.entity;

public class ShoppingCart {
	/**
	 * ����
	 */
	private int id;
	/**
	 * ��Ʒ��ɫ������id�����
	 */
	private int colorAndConfigureId;
	/**
	 * ��Ʒ����
	 */
	private int total;
	/**
	 * �ܼ�
	 */
	private double totalPrice;
	/**
	 * ѡ����Ʒ
	 */
	private boolean checked;
	/**
	 * �ײ�id
	 */
	private int comboId;
	/**
	 * �û�id
	 */
	private int huserId;
	/**
	 * ��ɫ�����ö���
	 */
	private ColorandConfigure colorandConfigure;
	/**
	 * �ײͶ���
	 */
	private Combo combo;
	/**
	 * �û�����
	 */
	private HUser hUser;
	
	
	
	public ColorandConfigure getColorandConfigure() {
		return colorandConfigure;
	}
	public Combo getCombo() {
		return combo;
	}
	public HUser gethUser() {
		return hUser;
	}
	public void setColorandConfigure(ColorandConfigure colorandConfigure) {
		this.colorandConfigure = colorandConfigure;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	public void sethUser(HUser hUser) {
		this.hUser = hUser;
	}
	public int getId() {
		return id;
	}
	public int getColorAndConfigureId() {
		return colorAndConfigureId;
	}
	public int getTotal() {
		return total;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public boolean isChecked() {
		return checked;
	}
	public int getComboId() {
		return comboId;
	}
	public int getHuserId() {
		return huserId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setColorAndConfigureId(int colorAndConfigureId) {
		this.colorAndConfigureId = colorAndConfigureId;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public void setComboId(int comboId) {
		this.comboId = comboId;
	}
	public void setHuserId(int huserId) {
		this.huserId = huserId;
	}
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(int id, int colorAndConfigureId, int total, double totalPrice, boolean checked, int comboId,
			int huserId) {
		super();
		this.id = id;
		this.colorAndConfigureId = colorAndConfigureId;
		this.total = total;
		this.totalPrice = totalPrice;
		this.checked = checked;
		this.comboId = comboId;
		this.huserId = huserId;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", colorAndConfigureId=" + colorAndConfigureId + ", total=" + total
				+ ", totalPrice=" + totalPrice + ", checked=" + checked + ", comboId=" + comboId + ", huserId="
				+ huserId + "]";
	}
	
	
	
	
}
