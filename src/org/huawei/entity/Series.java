package org.huawei.entity;

import java.io.Serializable;

public class Series implements Serializable {
	/**
	 * ����
	 */
	private int id;
	/**
	 * ϵ��ϸ������
	 */
	private String sName;
	/**
	 * ϵ��ϸ��ͼƬ
	 */
	private String image;
	/**
	 * ����id
	 */
	private int categoryId;
	/**
	 * �������
	 */
	private Category category;
	/**
	 * ��ϸ�ֹ�������Ʒ����
	 */
	private int reCommodityCount;
	
	
	public int getReCommodityCount() {
		return reCommodityCount;
	}
	public void setReCommodityCount(int reCommodityCount) {
		this.reCommodityCount = reCommodityCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Series() {
		super();
	}
	
	public Series(String sName, String image, int categoryId) {
		super();
		this.sName = sName;
		this.image = image;
		this.categoryId = categoryId;
	}
	public Series(int id, String sName, String image, int categoryId, Category category) {
		super();
		this.id = id;
		this.sName = sName;
		this.image = image;
		this.categoryId = categoryId;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Series [id=" + id + ", sName=" + sName + ", image=" + image + ", categoryId=" + categoryId
				+ ", category=" + category + "]";
	}
	
}
