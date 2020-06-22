package org.huawei.entity;

import java.io.Serializable;

/**
 * 地址实体类
 * 
 * @author Administrator
 *
 */
public class Address implements Serializable {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 用户id
	 */
	private int huserid;
	/**
	 * 收货人
	 */
	private String aName;
	/**
	 * 收货电话
	 */
	private String phone;
	/**
	 * 备选号码
	 */
	private String rePhone;
	/**
	 * 收货地址，国家地区
	 */
	private String country;
	/**
	 * 详细地址
	 */
	private String detail;
	/**
	 * 邮编
	 */
	private String postcode;
	/**
	 * 用户对象
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
