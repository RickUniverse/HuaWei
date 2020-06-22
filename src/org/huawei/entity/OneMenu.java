package org.huawei.entity;

import java.io.Serializable;
import java.util.List;

/**
 * һ���˵�
 * @author Administrator
 *
 */
public class OneMenu implements Serializable  {
	/**
	 * һ���˵�id
	 */
	private int id;
	/**
	 * ����id
	 */
	private int categoryId;
	/**
	 * �������
	 */
	private Category category;
	/**
	 * �����˵�����
	 */
	private List<TwoMenu> liTwoMenu;
	/**
	 * �����˵�����
	 */
	private TwoMenu twomenu;
	/**
	 * ϵ��id
	 */
	private List<Series> liSeries;
	
	public List<Series> getLiSeries() {
		return liSeries;
	}
	public void setLiSeries(List<Series> liSeries) {
		this.liSeries = liSeries;
	}
	public OneMenu(int id, int categoryId, Category category, List<TwoMenu> liTwoMenu, TwoMenu twomenu) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.category = category;
		this.liTwoMenu = liTwoMenu;
		this.twomenu = twomenu;
	}
	public TwoMenu getTwomenu() {
		return twomenu;
	}
	public void setTwomenu(TwoMenu twomenu) {
		this.twomenu = twomenu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<TwoMenu> getLiTwoMenu() {
		return liTwoMenu;
	}
	public void setLiTwoMenu(List<TwoMenu> liTwoMenu) {
		this.liTwoMenu = liTwoMenu;
	}
	public OneMenu() {
		super();
	}
	public OneMenu(int id, int categoryId, Category category, List<TwoMenu> liTwoMenu) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.category = category;
		this.liTwoMenu = liTwoMenu;
	}
	@Override
	public String toString() {
		return "OneMenu [id=" + id + ", categoryId=" + categoryId + ", category=" + category + ", liTwoMenu="
				+ liTwoMenu + ", twomenu=" + twomenu + "]";
	}
	
	
}
