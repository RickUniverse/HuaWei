package org.huawei.entity;

import java.io.Serializable;

/**
 * 配置表
 * @author Administrator
 *
 */
public class Configure implements Serializable {
	/**
	 * 配置id
	 */
	private int id;
	/**
	 * 配置名称
	 */
	private String cName;
	/**
	 * 判断当前颜色中是否包含该配置
	 * true：包含
	 * false：不包含
	 */
	private boolean isExisit;
	
	
	
	public boolean isExisit() {
		return isExisit;
	}
	public void setExisit(boolean isExisit) {
		this.isExisit = isExisit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Configure() {
		super();
	}
	public Configure(int id, String cName) {
		super();
		this.id = id;
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Configure [id=" + id + ", cName=" + cName + ", isExisit=" + isExisit + "]";
	}
	
}
