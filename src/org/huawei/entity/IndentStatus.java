package org.huawei.entity;

import java.io.Serializable;

/**
 * 订单状态实体类
 * @author Administrator
 *
 */
public class IndentStatus implements Serializable  {
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 状态名称
	 */
	private String sName;
	
	/**
	 * 判断某一个用户拥有该订单的数量
	 */
	private int count;
	
	
	
	public IndentStatus(int id, String sName, int count) {
		super();
		this.id = id;
		this.sName = sName;
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public String getsName() {
		return sName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public IndentStatus() {
		super();
	}
	public IndentStatus(int id, String sName) {
		super();
		this.id = id;
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "IndentStatus [id=" + id + ", sName=" + sName + ", count=" + count + "]";
	}
	
	
}
