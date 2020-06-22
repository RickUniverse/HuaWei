package org.huawei.entity;

import java.io.Serializable;

/**
 * ��ַʵ����
 * 
 * @author Administrator
 *
 */
public class Address implements Serializable {
	/**
	 * ����
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int huserid;
	/**
	 * �ջ���
	 */
	private String aName;
	/**
	 * �ջ��绰
	 */
	private String phone;
	/**
	 * ��ѡ����
	 */
	private String rePhone;
	/**
	 * �ջ���ַ�����ҵ���
	 */
	private String country;
	/**
	 * ��ϸ��ַ
	 */
	private String detail;
	/**
	 * �ʱ�
	 */
	private String postcode;
	/**
	 * �û�����
	 */
	private HUser hUser;
	
	
	
	
	public Address(int huserid, String aName, String phone, String country, String detail) {
		super();
		this.huserid = huserid;
		this.aName = aName;
		this.phone = phone;
		this.country = country;
		this.detail = detail;
	}
	public int getId() {
		return id;
	}
	public int getHuserid() {
		return huserid;
	}
	public String getaName() {
		return aName;
	}
	public String getPhone() {
		return phone;
	}
	public String getRePhone() {
		return rePhone;
	}
	public String getCountry() {
		return country;
	}
	public String getDetail() {
		return detail;
	}
	public String getPostcode() {
		return postcode;
	}
	public HUser gethUser() {
		return hUser;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setHuserid(int huserid) {
		this.huserid = huserid;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRePhone(String rePhone) {
		this.rePhone = rePhone;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public void sethUser(HUser hUser) {
		this.hUser = hUser;
	}
	public Address() {
		super();
	}
	public Address(int id, int huserid, String aName, String phone, String rePhone, String country, String detail,
			String postcode, HUser hUser) {
		super();
		this.id = id;
		this.huserid = huserid;
		this.aName = aName;
		this.phone = phone;
		this.rePhone = rePhone;
		this.country = country;
		this.detail = detail;
		this.postcode = postcode;
		this.hUser = hUser;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", huserid=" + huserid + ", aName=" + aName + ", phone=" + phone + ", rePhone="
				+ rePhone + ", country=" + country + ", detail=" + detail + ", postcode=" + postcode + ", hUser="
				+ hUser + "]";
	}
	
	
}
