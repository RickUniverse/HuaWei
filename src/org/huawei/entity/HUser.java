package org.huawei.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HUser implements Serializable {
	private int id;
	private String uName;
	private String uPassword;
	private String photo;
	private String phone;
	private String country;
	private Date birthday;
	private int total;
	private int onsaleCoupon;
	private int cashCoupon;
	private int petal;
	
	/**
	 * 购物车内选中商品的总价格
	 */
	private double totalPrice;
	/**
	 * 购物车内选中商品数量
	 */
	private int totalCheck;
	/**
	 * 购物车商品优惠价格
	 */
	private double youPrice;
	
	/**
	 * 默认地址
	 */
	private int defaultAddress;
	/**
	 * 默认地址对象
	 */
	private Address addredd;
	/**
	 * 地址集合
	 */
	private List<Address> addressLi;
	
	/**
	 * 我的订单数量
	 */
	private int totalIndent;
	
	
	public int getTotalIndent() {
		return totalIndent;
	}
	public void setTotalIndent(int totalIndent) {
		this.totalIndent = totalIndent;
	}
	public Address getAddredd() {
		return addredd;
	}
	public List<Address> getAddressLi() {
		return addressLi;
	}
	public void setAddredd(Address addredd) {
		this.addredd = addredd;
	}
	public void setAddressLi(List<Address> addressLi) {
		this.addressLi = addressLi;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public int getTotalCheck() {
		return totalCheck;
	}
	public double getYouPrice() {
		return youPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setTotalCheck(int totalCheck) {
		this.totalCheck = totalCheck;
	}
	public void setYouPrice(double youPrice) {
		this.youPrice = youPrice;
	}
	public int getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(int defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public HUser() {
		super();
	}
	@Override
	public String toString() {
		return "HUser [id=" + id + ", uName=" + uName + ", uPassword=" + uPassword + ", photo=" + photo + ", phone="
				+ phone + ", country=" + country + ", birthday=" + birthday + ", total=" + total + ", onsaleCoupon="
				+ onsaleCoupon + ", cashCoupon=" + cashCoupon + ", petal=" + petal + ", totalPrice=" + totalPrice
				+ ", totalCheck=" + totalCheck + ", youPrice=" + youPrice + ", defaultAddress=" + defaultAddress
				+ ", addredd=" + addredd + ", addressLi=" + addressLi + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getOnsaleCoupon() {
		return onsaleCoupon;
	}
	public void setOnsaleCoupon(int onsaleCoupon) {
		this.onsaleCoupon = onsaleCoupon;
	}
	public int getCashCoupon() {
		return cashCoupon;
	}
	public void setCashCoupon(int cashCoupon) {
		this.cashCoupon = cashCoupon;
	}
	public int getPetal() {
		return petal;
	}
	public void setPetal(int petal) {
		this.petal = petal;
	}
	
}
