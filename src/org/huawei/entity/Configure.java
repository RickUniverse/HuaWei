package org.huawei.entity;

import java.io.Serializable;

/**
 * ���ñ�
 * @author Administrator
 *
 */
public class Configure implements Serializable {
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String cName;
	/**
	 * �жϵ�ǰ��ɫ���Ƿ����������
	 * true������
	 * false��������
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
