package org.huawei.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ¥��
 * @author Administrator
 *
 */
public class Floor implements Serializable {
	/**
	 * ����
	 */
	private int id;
	/**
	 * ���id
	 */
	private int categoryId;
	/**
	 * ������
	 */
	private Category category;
	/**
	 * ϸ�ּ���
	 */
	private List<Series> liSeries;
	/**
	 * ¥������Ʒ����
	 */
	private List<Commodity> liCommodity;
	/**
	 * ������ɫ����
	 */
	private List<ColorandConfigure> liColorandConfigure;
	
	public List<ColorandConfigure> getLiColorandConfigure() {
		return liColorandConfigure;
	}
	public void setLiColorandConfigure(List<ColorandConfigure> liColorandConfigure) {
		this.liColorandConfigure = liColorandConfigure;
	}
	public int getId() {
		return id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public List<Series> getLiSeries() {
		return liSeries;
	}
	public List<Commodity> getLiCommodity() {
		return liCommodity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setLiSeries(List<Series> liSeries) {
		this.liSeries = liSeries;
	}
	public void setLiCommodity(List<Commodity> liCommodity) {
		this.liCommodity = liCommodity;
	}
	public Floor() {
		super();
	}
	public Floor(int id, int categoryId, Category category, List<Series> liSeries, List<Commodity> liCommodity) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.category = category;
		this.liSeries = liSeries;
		this.liCommodity = liCommodity;
	}
	@Override
	public String toString() {
		return "Floor [id=" + id + ", categoryId=" + categoryId + ", category=" + category + ", liSeries=" + liSeries
				+ ", liCommodity=" + liCommodity + "]";
	}
	
	
}
