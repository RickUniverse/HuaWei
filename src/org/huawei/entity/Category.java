package org.huawei.entity;

import java.io.Serializable;

/**
 * 种类 类
 * @author Administrator
 *
 */
public class Category implements Serializable  {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 种类名称
	 */
	private String sName;
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
	public Category() {
		super();
	}
	public Category(int id, String sName) {
		super();
		this.id = id;
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", sName=" + sName + "]";
	}
	
	
}
