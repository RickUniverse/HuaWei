package org.huawei.entity;

import java.io.Serializable;

/**
 * ���� ��
 * @author Administrator
 *
 */
public class Category implements Serializable  {
	/**
	 * ���
	 */
	private int id;
	/**
	 * ��������
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
