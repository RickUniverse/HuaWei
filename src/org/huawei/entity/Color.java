package org.huawei.entity;

import java.io.Serializable;

/**
 * 商品颜色
 * @author Administrator
 *
 */
public class Color implements Serializable {
	/**
	 * 颜色id
	 */
	private int id;
	/**
	 * 颜色名称
	 */
	private String cName;
	/**
	 * 查出当前的配置颜色id中的
	 */
	private boolean isExist;
	/**
	 * 颜色配置里面的
	 */
	private String images;
	
	public Color(int id, String cName, boolean isExist) {
		super();
		this.id = id;
		this.cName = cName;
		this.isExist = isExist;
	}
	
	public Color(int id, String cName, boolean isExist, String images) {
		super();
		this.id = id;
		this.cName = cName;
		this.isExist = isExist;
		this.images = images;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
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
	public Color() {
		super();
	}
	public Color(int id, String cName) {
		super();
		this.id = id;
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Color [id=" + id + ", cName=" + cName + ", isExist=" + isExist + ", images=" + images + "]";
	}
	
}
