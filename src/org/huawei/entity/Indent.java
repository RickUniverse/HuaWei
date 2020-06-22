package org.huawei.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class Indent implements Serializable  {
	/**
	 * ����id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int huserid;
	/**
	 * ����״̬
	 */
	private int Stateid;
	/**
	 * ����ѡ��
	 */
	private boolean checked;
	/**
	 * �µ�ʱ��
	 */
	private Date orderdate;
	/**
	 * ��ַid
	 */
	private int addressId;
	/**
	 * ʵ����
	 */
	private double payment;
	/**
	 * ����
	 */
	private int integral;
	/**
	 * ����״̬����
	 */
	private IndentStatus indentState;
	/**
	 * �û�����
	 */
	private HUser hUser;
	/**
	 * ��ַ����
	 */
	private Address address;
	
	/**
	 * �������鼯��
	 */
	private List<IndentDetail> indentDetailLi;
	
	
	
	
	
	
	public List<IndentDetail> getIndentDetailLi() {
		return indentDetailLi;
	}
	public void setIndentDetailLi(List<IndentDetail> indentDetailLi) {
		this.indentDetailLi = indentDetailLi;
	}
	public int getId() {
		return id;
	}
	public int getHuserid() {
		return huserid;
	}
	public int getStateid() {
		return Stateid;
	}
	public boolean isChecked() {
		return checked;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public int getAddressId() {
		return addressId;
	}
	public double getPayment() {
		return payment;
	}
	public int getIntegral() {
		return integral;
	}
	public IndentStatus getIndentState() {
		return indentState;
	}
	public HUser gethUser() {
		return hUser;
	}
	public Address getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setHuserid(int huserid) {
		this.huserid = huserid;
	}
	public void setStateid(int stateid) {
		Stateid = stateid;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public void setIndentState(IndentStatus indentState) {
		this.indentState = indentState;
	}
	public void sethUser(HUser hUser) {
		this.hUser = hUser;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Indent() {
		super();
	}
	public Indent(int id, int huserid, int stateid, boolean checked, Date orderdate, int addressId, double payment,
			int integral, IndentStatus indentState, HUser hUser, Address address) {
		super();
		this.id = id;
		this.huserid = huserid;
		Stateid = stateid;
		this.checked = checked;
		this.orderdate = orderdate;
		this.addressId = addressId;
		this.payment = payment;
		this.integral = integral;
		this.indentState = indentState;
		this.hUser = hUser;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Indent [id=" + id + ", huserid=" + huserid + ", Stateid=" + Stateid + ", checked=" + checked
				+ ", orderdate=" + orderdate + ", addressId=" + addressId + ", payment=" + payment + ", integral="
				+ integral + ", indentState=" + indentState + ", hUser=" + hUser + ", address=" + address
				+ "]";
	}
	
	
}
